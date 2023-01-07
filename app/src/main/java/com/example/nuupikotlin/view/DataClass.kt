package com.example.nuupikotlin.view

import android.os.Parcel
import android.os.Parcelable

data class DataClass(var dataNombre:String,var dataImage:Int, var dataDescrip:String, var dataPrecio:String):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readString()!!
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(dataNombre)
        parcel.writeInt(dataImage)
        parcel.writeString(dataDescrip)
        parcel.writeString(dataPrecio)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<DataClass> {
        override fun createFromParcel(parcel: Parcel): DataClass {
            return DataClass(parcel)
        }

        override fun newArray(size: Int): Array<DataClass?> {
            return arrayOfNulls(size)
        }
    }

}
