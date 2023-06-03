package com.example.demo.model;


import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

/**
 * テーブルの共通項目を定義したクラスです。</br>
 * 全てのEntityクラスはこのクラスを継承して作成します。
 */
@MappedSuperclass
@Data
public class CommonEntity {

	/** データ登録日時 */
	@Column(name = "create_date")
	@Temporal(TemporalType.DATE)
	private Date createdate;

	/** データ更新日時 */
	@Column(name = "update_date")
	@Temporal(TemporalType.DATE)
	private Date updateDate;

	/**
	* データ登録前に共通的に実行されるメソッド
	*/
	@PrePersist
	public void preInsert() {
		Date date = new Date();
		setCreatedate(date);
		setUpdateDate(date);
	}

	/**
	* データ更新前に共通的に実行されるメソッド
	*/
	@PreUpdate
	public void preUpdate() {
		setUpdateDate(new Date());
	}
}

