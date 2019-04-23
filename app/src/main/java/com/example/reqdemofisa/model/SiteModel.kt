package com.example.reqdemofisa.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class SiteModel(val name : String = "") : Parcelable{

 //attributes
 var projectionEPRC : Float = 0f
 var projection_0_14 : Float = 0f
 var projection_1_29 : Float = 0f
 var projection30_59 : Float = 0f
 var projection_60_89 : Float= 0f
 var projection_90_119 : Float = 0f
 var projection_120_149 : Float = 0f
 var projection_150_179 : Float = 0f
 var projection_90_plus : Float = 0f
 var projectionTaso : Float = 0f
 var tasoEprc : Float = 0f
 var taso_0_14 : Float = 0f
 var taso_30_59 : Float = 0f
 var taso_90_plus : Float = 0f
 var rankEprc : Int= 0
 var rank_0_14 : Int= 0
 var rank_30_59 : Int= 0
 var rank_90_plus : Int = 0

 //constructor

 constructor(
  name: String?,
  projectionEPRC: Float,
  projection_0_14: Float,
  projection_1_29: Float,
  projection30_59: Float,
  projection_60_89: Float,
  projection_90_119: Float,
  projection_120_149: Float,
  projection_150_179: Float,
  projection_90_plus: Float,
  projectionTaso: Float,
  tasoEprc: Float,
  taso_0_14: Float,
  taso_30_59: Float,
  taso_90_plus: Float,
  rankEprc: Int,
  rank_0_14: Int,
  rank_30_59: Int,
  rank_90_plus: Int
 ) : this() {
  this.projectionEPRC = projectionEPRC
  this.projection_0_14 = projection_0_14
  this.projection_1_29 = projection_1_29
  this.projection30_59 = projection30_59
  this.projection_60_89 = projection_60_89
  this.projection_90_119 = projection_90_119
  this.projection_120_149 = projection_120_149
  this.projection_150_179 = projection_150_179
  this.projection_90_plus = projection_90_plus
  this.projectionTaso = projectionTaso
  this.tasoEprc = tasoEprc
  this.taso_0_14 = taso_0_14
  this.taso_30_59 = taso_30_59
  this.taso_90_plus = taso_90_plus
  this.rankEprc = rankEprc
  this.rank_0_14 = rank_0_14
  this.rank_30_59 = rank_30_59
  this.rank_90_plus = rank_90_plus
 }


}