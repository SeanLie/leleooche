package org.jeecgframework.web.system.pojo.base;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.jeecgframework.core.common.entity.BaseIDEntity;

/**
 * 用户-组织机构 实体
 * <p/>
 * <p>
 * <b>User:</b> zhanggm
 * <a href="mailto:guomingzhang2008@gmail.com">guomingzhang2008@gmail.com</a>
 * </p>
 * <p>
 * <b>Date:</b> 2014-08-22 15:39
 * </p>
 *
 * @author 张国明
 */
@Entity
@Table(name = "t_s_user_org")
public class TSUserOrg extends BaseIDEntity implements java.io.Serializable {
	private TSUser tsUser;
	private TSDepart tsDepart;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	public TSUser getTsUser() {
		return tsUser;
	}

	public void setTsUser(TSUser tsUser) {
		this.tsUser = tsUser;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "org_id")
	public TSDepart getTsDepart() {
		return tsDepart;
	}

	public void setTsDepart(TSDepart tsDepart) {
		this.tsDepart = tsDepart;
	}
}
