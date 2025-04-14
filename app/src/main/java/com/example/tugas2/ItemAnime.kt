package com.example.tugas2

import android.os.Parcel
import android.os.Parcelable

data class ItemAnime(
    val imageResId: Int,
    val judul: String,
    val nama: String,
    val genre: String,
    val deskripsi: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: ""
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(imageResId)
        parcel.writeString(judul)
        parcel.writeString(nama)
        parcel.writeString(genre)
        parcel.writeString(deskripsi)
    }

    override fun describeContents(): Int = 0

    companion object CREATOR : Parcelable.Creator<ItemAnime> {
        override fun createFromParcel(parcel: Parcel): ItemAnime = ItemAnime(parcel)
        override fun newArray(size: Int): Array<ItemAnime?> = arrayOfNulls(size)
    }
}
