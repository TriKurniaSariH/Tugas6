package com.example.tugas2

import android.os.Parcel
import android.os.Parcelable

data class ItemAnime(
    val imageResId: Int,
    val judul: String,
    val nama: String,
    val genre: String,
    val deskripsi: String,
    var isFavorite: Boolean = false
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readByte() != 0.toByte()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(imageResId)
        parcel.writeString(judul)
        parcel.writeString(nama)
        parcel.writeString(genre)
        parcel.writeString(deskripsi)
        parcel.writeByte(if (isFavorite) 1 else 0)
    }

    override fun describeContents(): Int = 0

    companion object CREATOR : Parcelable.Creator<ItemAnime> {
        override fun createFromParcel(parcel: Parcel): ItemAnime = ItemAnime(parcel)
        override fun newArray(size: Int): Array<ItemAnime?> = arrayOfNulls(size)
    }
}
