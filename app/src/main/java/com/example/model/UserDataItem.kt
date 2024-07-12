package com.example.model

import android.os.Parcel
import android.os.Parcelable

data class UserDataItem(
    val login: String,
    val id: Int,
    val avatar_url: String,
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString().toString(),
        parcel.readInt(),
        parcel.readString().toString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(login)
        parcel.writeInt(id)
        parcel.writeString(avatar_url)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<UserDataItem> {
        override fun createFromParcel(parcel: Parcel): UserDataItem {
            return UserDataItem(parcel)
        }

        override fun newArray(size: Int): Array<UserDataItem?> {
            return arrayOfNulls(size)
        }
    }
}