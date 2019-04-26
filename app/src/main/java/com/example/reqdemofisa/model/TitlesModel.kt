package com.example.reqdemofisa.model

import android.os.Parcel
import android.os.Parcelable

data class TitlesModel(var title: String = ""
                       , var id: Int
                       , var expanded: Boolean = false
                       ): Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readInt(),
        parcel.readByte() != 0.toByte()
    ) {
    }

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest!!.writeString(title)
        dest!!.writeInt(id)
        dest!!.writeByte(if(expanded) 1 else 0)
    }

    override fun describeContents(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun toString(): String {
        return "TitlesModel(title='$title', id=$id, expanded=$expanded)"
    }

    companion object CREATOR : Parcelable.Creator<TitlesModel> {
        override fun createFromParcel(parcel: Parcel): TitlesModel {
            return TitlesModel(parcel)
        }

        override fun newArray(size: Int): Array<TitlesModel?> {
            return arrayOfNulls(size)
        }
    }

}