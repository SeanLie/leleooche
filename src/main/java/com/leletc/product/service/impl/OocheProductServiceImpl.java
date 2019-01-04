package com.leletc.product.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.jeecgframework.core.util.MyBeanUtils;
import org.jeecgframework.jwt.util.menu.ResponseMessageCodeEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.leletc.base.util.LeletcConstants;
import com.leletc.product.dao.ProductsDao;
import com.leletc.product.dao.UserProductsDao;
import com.leletc.product.entity.BaseProductsEntity;
import com.leletc.product.entity.BaseUserProductsEntity;
import com.leletc.product.service.IOOcheProductService;
import com.leletc.product.web.api.response.BaseProductsRsp;
import com.leletc.product.web.bo.BaseProductsBO;

@Service("oocheProductService")
@Transactional
public class OocheProductServiceImpl extends CommonServiceImpl implements IOOcheProductService {

	private static final String TAG = OocheProductServiceImpl.class.getSimpleName() + " - 服务产品 - ";

	private static Logger logger = LoggerFactory.getLogger(OocheProductServiceImpl.class);

	// private AutoBaseUserProductsDaoExe autoBaseUserProductsDaoExe;

	@Autowired
	private UserProductsDao userProductsDao;

	@Autowired
	private ProductsDao productsDao;

	@Override
	public BaseProductsRsp getUserProductByUserId(String userId) throws Exception {
		BaseProductsRsp rsp = new BaseProductsRsp();
		rsp.setRspcode(ResponseMessageCodeEnum.SUCCESS.getCode());
		rsp.setChannel(LeletcConstants.PLATFORM_WX);
		// ---------------------查询用户产品信息，并整合其父级产品信息 --------------------
		// 查询所有的产品信息
		List<BaseProductsEntity> products = productsDao.getProductsByUserId(userId);
		if (CollectionUtils.isEmpty(products)) {
			logger.error(TAG + "{}", "您不是服务商或供应商，现在不能预约");
			rsp.setMsg("您不是服务商或供应商，现在不能预约");
			rsp.setRspcode(ResponseMessageCodeEnum.DO_NOT_ERROR.getCode());
			return rsp;
		}
		// 保存用户对应的产品配置
		Map<String, BaseUserProductsEntity> userProductMap = new HashMap<>();
		final List<BaseUserProductsEntity> userProductList = userProductsDao.getListByUserId(userId);
		for (BaseUserProductsEntity userProduct : userProductList) {
			userProductMap.put(userProduct.getProductId(), userProduct);
		}
		// 封装成业务对象返回至前端
		List<BaseProductsBO> productsBOList = new ArrayList<>();
		BaseProductsBO productsBO;
		for (BaseProductsEntity product : products) {
			productsBO = new BaseProductsBO();
			// 复制产品对象
			MyBeanUtils.copyBeanNotNull2Bean(product, productsBO);
			final BaseUserProductsEntity up = userProductMap.get(product.getId());
			// 复制用户产品对象
			org.springframework.beans.BeanUtils.copyProperties(up, productsBO, "id");
			productsBOList.add(productsBO);
		}
		rsp.setProducts(productsBOList);
		// 所有产品信息key=id,value=产品对象
		/*
		 * Map<String, BaseProductsEntity> productsMap = new HashMap<>(); for
		 * (BaseProductsEntity product : products) { // 将所有产品信息保存到Map中
		 * productsMap.put(product.getId(), product); } // 封装所有的父子级 Map<String,
		 * List<String>> separateParentMap = new HashMap<>(); // 临时子级对象集合 List<String>
		 * childTempList; for (String id : productsMap.keySet()) { final
		 * BaseProductsEntity entity = productsMap.get(id); String parentId =
		 * entity.getParentProductId(); // 父ID为空，则将key设置为对象的ID if
		 * (StringUtils.isBlank(parentId)) { parentId = id; } if
		 * (separateParentMap.containsKey(parentId)) { // 如果已包含，则此ID为上级ID，将子级添加到此ID集合中
		 * childTempList = separateParentMap.get(parentId); } else { childTempList = new
		 * ArrayList<>(); if (!id.equals(parentId)) { childTempList.add(id); } }
		 * separateParentMap.put(parentId, childTempList); } //
		 * 封装返回对象，获得用户产品业务对象，父级不需要用户产品信息，叶子节点才需要 List<UserProductsBO> userProductsBOList
		 * = new ArrayList<>(); final List<BaseUserProductsEntity> userProductList =
		 * userProductsDao.getListByUserId(userId); if
		 * (!CollectionUtils.isEmpty(userProductList)) { ProductNode current;
		 * List<ProductNode> parents; List<ProductNode> currentList; Map<String,
		 * BaseUserProductsEntity> userProductMap = new HashMap<>(); for
		 * (BaseUserProductsEntity product : userProductList) { final String productId =
		 * product.getProductId(); userProductMap.put(productId, product); } // 用户产品业务对象
		 * UserProductsBO userProductsBO = new UserProductsBO(); for (Map.Entry<String,
		 * BaseUserProductsEntity> entry : userProductMap.entrySet()) { final String
		 * productId = entry.getKey(); // 根据叶子节点ID获得其父级集合 parents =
		 * getParentsByChildId(separateParentMap, productId); currentList = new
		 * ArrayList<>(); current = new ProductNode(); current.setId(productId);
		 * current.setLeaf(true); currentList.add(current); parents.addAll(currentList);
		 * // 为叶子节点设置业务对象 if (!CollectionUtils.isEmpty(parents)) { for (ProductNode pl :
		 * parents) { if (pl.isLeaf && pl.getId() == productId) { // 复制用户产品实体对象至业务对象
		 * userProductsBO = new UserProductsBO();
		 * MyBeanUtils.copyBeanNotNull2Bean(entry.getValue(), userProductsBO); }
		 * userProductsBO.setProduct(productsMap.get(productId));
		 * userProductsBOList.add(userProductsBO); } } } } else {
		 * rsp.setError("未查询到数据");
		 * rsp.setRspcode(ResponseMessageCodeEnum.NULL_ERROR.getCode()); return rsp; }
		 */
		// rsp.setUser(this.get(TSUser.class, userId));
		// 测试节点
		/*
		 * final List<ProductNode> allProduct = getAllProduct(products); // 设置子级 final
		 * List<ProductNode> productNodes = setNodeChildren(allProduct,
		 * "402881e765aa19d10165aa1ae75a0001"); List<String> result = new ArrayList<>();
		 * getAllNodeId(productNodes, result);
		 */
		rsp.setMsg("返回成功");
		return rsp;
	}

	private List<ProductNode> getParentsByChildId(Map<String, List<String>> parentChildMap, String childId) {
		List<ProductNode> returnList = new ArrayList<>();
		if (!CollectionUtils.isEmpty(parentChildMap)) {
			if (null != childId) {
				String tempChildId;
				for (Map.Entry<String, List<String>> entry : parentChildMap.entrySet()) {
					final List<String> list = entry.getValue();
					if (!CollectionUtils.isEmpty(list)) {
						for (String id : list) {
							if (id.equals(childId)) {
								ProductNode productNode = new ProductNode();
								productNode.setId(entry.getKey());
								productNode.setLeaf(false);
								returnList.add(productNode);
								break;
							}
							// 未找到则继续找
							tempChildId = id;
							getParentsByChildId(parentChildMap, tempChildId);
						}
					}
				}
			}
		}
		return returnList;
	}

	/**
	 * 获得所有节点的ID
	 *
	 * @param root   所有节点List
	 * @param result 返回的节点ID List
	 * @return 返回的节点ID List
	 */
	private List<String> getAllNodeId(List<ProductNode> root, List<String> result) {
		for (ProductNode productNode : root) {
			result.add(productNode.getId());
			if (null != productNode.getChildren()) {
				getAllNodeId(productNode.getChildren(), result);
			}
		}
		return result;
	}

	/**
	 *
	 * @param rootNodeList
	 * @return
	 */
	private List<ProductNode> traversingNodeList(List<ProductNode> rootNodeList) {
		List<ProductNode> children;
		/*
		 * rootNodeList.forEach(productNode -> { });
		 */
		for (ProductNode productNode : rootNodeList) {
			children = new ArrayList<>();
			if (!CollectionUtils.isEmpty(productNode.getChildren())) {
				children = productNode.getChildren();
			}
			// 遍历子集获得所有节点
			traversingNodeList(children);
		}
		return rootNodeList;
	}

	/**
	 * 设置子级
	 *
	 * @param nodeList        节点数据
	 * @param parentProductId 父级ID
	 * @return
	 */
	private List<ProductNode> setNodeChildren(List<ProductNode> nodeList, String parentProductId) {
		List<ProductNode> childList = new ArrayList<>();
		for (int i = 0; i < nodeList.size(); i++) {
			final ProductNode productNode = nodeList.get(i);
			if (null != productNode) {
				// 如果当前的父级ID等于传入的父ID，则为当前节点设置为其子级
				if (productNode.getParentProductId().equals(parentProductId)) {
					productNode.setChildren(setNodeChildren(nodeList, productNode.getId()));
					childList.add(productNode);
				}
			}
		}
		return traversingNodeList(childList);
	}

	/**
	 * 构造产品数据结构
	 *
	 * @param productsEntityList 产品实体对象List
	 * @return
	 */
	private List<ProductNode> getAllProduct(List<BaseProductsEntity> productsEntityList) {
		List<ProductNode> result = new ArrayList<>();
		for (BaseProductsEntity item : productsEntityList) {
			ProductNode node = new ProductNode();
			node.setId(item.getId());
			node.setParentProductId(item.getParentProductId());
			node.setChildren(null);
			result.add(node);
		}
		return result;
	}

	class ProductNode extends BaseProductsEntity {
		private List<ProductNode> children;
		/** 是否为叶子节点 */
		private boolean isLeaf;

		public boolean isLeaf() {
			return isLeaf;
		}

		public void setLeaf(boolean leaf) {
			isLeaf = leaf;
		}

		public List<ProductNode> getChildren() {
			return children;
		}

		public void setChildren(List<ProductNode> children) {
			this.children = children;
		}
	}

	@Override
	public List<BaseProductsEntity> getBaseProducts(String userId, String parentProductId) throws Exception {
		// 获取到org_code去匹配表auto_base_products中sys_org_code和sys_company_code字段，得到相应产品数据列表
		// List<AutoBaseProductsRsp> autoBaseProductsRsp =
		// AutoBaseProductsDaoExe.getAutoBaseProductDetil(userId, parentId);
		return productsDao.getListByUserId(userId, parentProductId, "1");
	}

//	public List<AutoBaseProductsRsp> getAutoBaseProduct1(String user_id, String parent_product_id) throws Exception {
//		// 1.0 获取到用户ID之后在去t_s_base_user获得departid
//		TSUser currentUser = ResourceUtil.getSessionUser();
//		String departid = currentUser.getDepartid();
//
//		// 2.0 获取departid，在去表t_s_depart中匹配ID字段（departid）获取t_s_depart中org_code
//		TSDepart tsDepart = TSDepartDaoExe.getOrgCodeByDepartId(departid);
//
//		String org_code = tsDepart.getOrgCode();
//
//		// 3.0
//		// 获取到org_code去匹配表auto_base_products中sys_org_code和sys_company_code字段，得到相应产品数据列表
//
//		List<AutoBaseProductsRsp> autoBaseProductsRsp = AutoBaseProductsDaoExe.getAutoBaseProductByOrgCode(org_code);
//		return autoBaseProductsRsp;
//	}

}
