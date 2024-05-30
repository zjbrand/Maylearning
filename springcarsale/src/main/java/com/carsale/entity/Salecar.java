package com.carsale.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Salecar {
	
	private Integer carid;//ID
	private String carBrand;//車の型
	private Date produceDate;//生産時間
	private Double salePrice;//価格
	private Integer odometer;//里程
	private String photo;//写真ファイルの名
	private String owner;//車輌保有者
	private boolean gender;//性別
	private String phonenum;//電話番号
	private String address;//客様の居住地
	private Date modifyTime;//改修時間	

}
