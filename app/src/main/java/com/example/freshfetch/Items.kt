package com.example.project

import android.os.Parcel
import android.os.Parcelable

public data class Items (val name: String,val price:String,val image:Int, val description:String):Parcelable {
 constructor(parcel: Parcel) : this(
  parcel.readString()!!,
  parcel.readString()!!,
  parcel.readInt(),
  parcel.readString()!!
 ) {
 }

 override fun writeToParcel(parcel: Parcel, flags: Int) {
  parcel.writeString(name)
  parcel.writeString(price)
  parcel.writeInt(image)
  parcel.writeString(description)
 }

 override fun describeContents(): Int {
  return 0
 }

 companion object CREATOR : Parcelable.Creator<Items> {
  override fun createFromParcel(parcel: Parcel): Items {
   return Items(parcel)
  }

  override fun newArray(size: Int): Array<Items?> {
   return arrayOfNulls(size)
  }
 }
}