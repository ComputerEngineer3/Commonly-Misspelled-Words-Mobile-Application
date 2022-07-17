package com.example.kartrlanszckler

import com.example.kartrlanszckler.apiDataClasses.*
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    @GET("Kullanicilar/KullaniciOturumDogrulama")
    suspend fun OturumDogrulama(
            @Query("kullaniciAd") kullaniciAd:String,
            @Query("sifre") sifre :String
    ) : Boolean


    @GET("Kullanicilar/KullaniciVarMi")
    suspend fun GetKullanici(
            @Query("kullaniciAd") kullaniciAd:String
    ) : KullaniciClass


    @GET("Kullanicilar/KullaniciEkle")
    suspend fun UyeOl(
            @Query("kullaniciAd") kullaniciAd:String,
            @Query("sifre") sifre:String,
            @Query("yas") yas:Int
    ) : Boolean


    @GET("Kelimeler/TumKelimeleriGetir")
    suspend fun KelimeleriGetir() : List<KelimelerClass>


    @GET("Kelimeler/ArananKelimeyiGetir")
    suspend fun ArananKelimeleriGetir(
            @Query("aranacakKelime") aranacakKelime:String?
    ) : List<KelimelerClass>


    @GET("Kelimeler/TestKelimeleriniGetir")
    suspend fun TestIcinKelimeleriGetir() : List<KelimelerClass>


    @GET("YanlisKelimeler/TumYanlisYapilanKelimeleriListele")
    suspend fun YanlisYapilanKelimeleriGetir(
            @Query("kullaniciid") kullaniciid:Int?
    ) : List<YanlisKelimelerClass>



    @GET("GenelSiralama/GunlukSiralamaGetir")
    suspend fun GunlukSiralamaGetir() : List<SiralamaClass>

    @GET("GenelSiralama/AylikSiralamaGetir")
    suspend fun AylikSiralamaGetir() : List<SiralamaClass>

    @GET("GenelSiralama/GenelSiralamaGetir")
    suspend fun GenelSiralamaGetir() : List<SiralamaClass>

    @GET("GenelSiralama/GenelSiralamaToplamPuanGetir")
    suspend fun KullanicininToplamPuaniniGetir(
            @Query("odulPuankId") odulPuankId:Int
    ) : Int


    @GET("GenelSiralama/SiralamaEkle")
    suspend fun GenelSiralamaEkle(
            @Query("kullaniciId") kullaniciId:Int,
            @Query("dogruSayisi") dogruSayisi:Int,
            @Query("yanlisSayisi") yanlisSayisi:Int,
            @Query("puan") puan:Int
    ) : Boolean


    @GET("YanlisKelimeler/YanlisYapilanKelimeEkle")
    suspend fun YanlisYapilanKelimeEkle(
            @Query("kullaniciId") kullaniciId:Int,
            @Query("kelimeId") kelimeId:Int
    ) : Boolean


}