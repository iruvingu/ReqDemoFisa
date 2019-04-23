package com.example.reqdemofisa.model
import android.os.Parcel
import android.os.Parcelable

data class SiteModel(val name : String = ""
                     ,val projectionEPRC : Float = 0f
                     ,val projection_0_14 : Float = 0f
                     ,val projection_1_29 : Float = 0f
                     ,val projection30_59 : Float = 0f
                     ,val projection_60_89 : Float = 0f
                     ,val projection_90_119 : Float = 0f
                     ,val projection_120_149 : Float = 0f
                     ,val projection_150_179 : Float = 0f
                     ,val projection_90_plus : Float = 0f
                     ,val projectionTaso : Float = 0f

                     ,val tasoEprc : Float = 0f
                     ,val taso_0_14 : Float = 0f
                     ,val taso_30_59 : Float = 0f
                     ,val taso_90_plus : Float = 0f

                     ,val rankEprc : Int = 0
                     ,val rank_0_14 : Int = 0
                     ,val rank_30_59 : Int = 0
                     ,val rank_90_plus : Int = 0) : Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readFloat(),
        parcel.readFloat(),
        parcel.readFloat(),
        parcel.readFloat(),
        parcel.readFloat(),
        parcel.readFloat(),
        parcel.readFloat(),
        parcel.readFloat(),
        parcel.readFloat(),
        parcel.readFloat(),
        parcel.readFloat(),
        parcel.readFloat(),
        parcel.readFloat(),
        parcel.readFloat(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeFloat(projectionEPRC)
        parcel.writeFloat(projection_0_14)
        parcel.writeFloat(projection_1_29)
        parcel.writeFloat(projection30_59)
        parcel.writeFloat(projection_60_89)
        parcel.writeFloat(projection_90_119)
        parcel.writeFloat(projection_120_149)
        parcel.writeFloat(projection_150_179)
        parcel.writeFloat(projection_90_plus)
        parcel.writeFloat(projectionTaso)
        parcel.writeFloat(tasoEprc)
        parcel.writeFloat(taso_0_14)
        parcel.writeFloat(taso_30_59)
        parcel.writeFloat(taso_90_plus)
        parcel.writeInt(rankEprc)
        parcel.writeInt(rank_0_14)
        parcel.writeInt(rank_30_59)
        parcel.writeInt(rank_90_plus)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<SiteModel> {
        override fun createFromParcel(parcel: Parcel): SiteModel {
            return SiteModel(parcel)
        }

        override fun newArray(size: Int): Array<SiteModel?> {
            return arrayOfNulls(size)
        }
    }

}