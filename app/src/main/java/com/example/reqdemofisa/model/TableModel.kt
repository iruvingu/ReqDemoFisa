package com.example.reqdemofisa.model

import android.os.Parcel
import android.os.Parcelable

data class TableModel(val name: String = ""
                      , val actual: Int = 0
                      , val proy: Float = 0f
                      , val meta: Float = 0f
                      , val rank: Int = 0
                      , val taso: Float = 0f) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readInt(),
        parcel.readFloat(),
        parcel.readFloat(),
        parcel.readInt(),
        parcel.readFloat()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeInt(actual)
        parcel.writeFloat(proy)
        parcel.writeFloat(meta)
        parcel.writeInt(rank)
        parcel.writeFloat(taso)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<TableModel> {
        override fun createFromParcel(parcel: Parcel): TableModel {
            return TableModel(parcel)
        }

        override fun newArray(size: Int): Array<TableModel?> {
            return arrayOfNulls(size)
        }
    }
}