package com.example.tugas2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager

class ListAnimeActivity : AppCompatActivity() {

    private lateinit var animeRecyclerView: RecyclerView
    private lateinit var animeAdapter: MyAdapter
    private lateinit var listAnime: ArrayList<ItemAnime>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_anime)

        animeRecyclerView = findViewById(R.id.animeRV)
        listAnime = ArrayList()

        listAnime.add(
            ItemAnime(
                R.drawable.one_piece,
                "One Piece",
                "Eiichiro Oda",
                "Adventure, Fantasy, Action",
                "Petualangan Monkey D. Luffy dan kru Topi Jerami dalam mencari harta karun legendaris One Piece. " +
                        "Mereka menjelajahi Grand Line dan menghadapi banyak musuh kuat yang menghalangi jalan mereka. " +
                        "Dengan kekuatan buah iblis dan persahabatan, mereka terus bertahan di tengah bahaya. " +
                        "Misteri dunia, sejarah rahasia, dan makna kebebasan menjadi fokus utama kisah ini. " +
                        "Sebuah perjalanan epik penuh tawa, air mata, dan semangat tak tergoyahkan."
            )
        )

        listAnime.add(
            ItemAnime(
                R.drawable.gintama,
                "Gintama",
                "Hideaki Sorachi",
                "Action, Comedy, Sci-Fi",
                "Di kota Edo yang diserbu alien, Gintoki Sakata menjalani hidup sebagai samurai pemalas. " +
                        "Bersama Shinpachi dan Kagura, mereka menerima pekerjaan aneh sebagai Yorozuya. " +
                        "Kisahnya konyol, penuh parodi, namun bisa berubah menjadi sangat emosional. " +
                        "Dari pertempuran antar fraksi sampai kisah masa lalu yang menyayat hati. " +
                        "Gintama adalah campuran kekacauan, komedi, dan pesan kehidupan mendalam."
            )
        )

        listAnime.add(
            ItemAnime(
                R.drawable.boruto,
                "Boruto",
                "Ukyo Kodachi",
                "Action, Adventure, Ninja",
                "Boruto adalah anak dari Hokage ketujuh, Naruto Uzumaki, yang hidup di era damai. " +
                        "Meski punya bakat hebat, ia merasa tertindas oleh bayang-bayang sang ayah. " +
                        "Bersama teman-temannya, ia menjelajahi dunia ninja dan menghadapi ancaman baru. " +
                        "Perkembangan teknologi juga membawa perubahan besar pada dunia shinobi. " +
                        "Boruto berjuang menemukan jalannya sendiri dan membuktikan kemampuannya."
            )
        )

        listAnime.add(
            ItemAnime(
                R.drawable.theroyaltutor,
                "The Royal Tutor",
                "Higasa Akai",
                "Comedy, Slice of Life",
                "Heine Wittgenstein, guru misterius dengan tubuh kecil, datang ke istana kerajaan. " +
                        "Tugasnya adalah membimbing empat pangeran muda yang keras kepala dan unik. " +
                        "Meski awalnya diremehkan, pendekatan lembutnya membawa perubahan besar. " +
                        "Setiap pangeran menghadapi masalah pribadi yang menyentuh dan dalam. " +
                        "Serial ini menyoroti pertumbuhan karakter dan nilai kedewasaan sejati."
            )
        )

        listAnime.add(
            ItemAnime(
                R.drawable.maid,
                "Miss Kobayashi's Dragon Maid",
                "Cool-kyou Shinja",
                "Comedy, Fantasy, Slice of Life",
                "Kobayashi adalah pegawai kantoran yang hidupnya berubah total setelah bertemu naga. " +
                        "Tohru, seekor naga, menjadi pembantunya dan mulai tinggal bersamanya. " +
                        "Bersama naga lain seperti Kanna dan Elma, rumah mereka jadi penuh warna. " +
                        "Cerita ini penuh komedi absurd, momen manis, dan hubungan antar makhluk berbeda. " +
                        "Keseharian yang aneh tapi hangat menjadi inti kisah ini."
            )
        )

        listAnime.add(
            ItemAnime(
                R.drawable.assassination_cr,
                "Assassination Classroom",
                "Yūsei Matsui",
                "Action, Comedy, School",
                "Makhluk asing yang super kuat menjadi guru kelas 3-E di sebuah sekolah. " +
                        "Ia berjanji akan menghancurkan bumi kecuali murid-muridnya bisa membunuhnya. " +
                        "Namun alih-alih takut, para murid justru belajar banyak dari sang guru. " +
                        "Setiap murid mendapat perhatian khusus dan berkembang luar biasa. " +
                        "Kombinasi aksi, komedi, dan drama sekolah membuat anime ini sangat berkesan."
            )
        )

        listAnime.add(
            ItemAnime(
                R.drawable.spyxfams,
                "Spy x Family",
                "Tatsuya Endo",
                "Action, Comedy, Slice of Life",
                "Seorang mata-mata bernama Twilight menyamar sebagai ayah dalam misi penting. " +
                        "Ia membentuk keluarga palsu dengan pembunuh bayaran dan anak cenayang. " +
                        "Ketiganya menyembunyikan identitas asli masing-masing demi misi dan keamanan. " +
                        "Namun, dari hubungan palsu tumbuh rasa sayang dan ikatan yang tak terduga. " +
                        "Cerita ini unik, lucu, dan penuh ketegangan serta kehangatan keluarga."
            )
        )

        listAnime.add(
            ItemAnime(
                R.drawable.drstone,
                "Dr. Stone",
                "Riichiro Inagaki, Boichi (artist)",
                "Sci-Fi, Adventure",
                "Dunia tiba-tiba membatu selama ribuan tahun karena fenomena misterius. " +
                        "Senku, jenius sains, terbangun dan bertekad membangun kembali peradaban manusia. " +
                        "Dengan ilmu pengetahuan, ia menciptakan kembali teknologi dari nol. " +
                        "Pertarungan antara akal dan kekuatan otot pun dimulai melawan kerajaan baru. " +
                        "Dr. Stone adalah perpaduan edukasi sains dan petualangan yang seru."
            )
        )

        listAnime.add(
            ItemAnime(
                R.drawable.black_clover,
                "Black Clover",
                "Yūki Tabata",
                "Action, Magic, Fantasy",
                "Asta terlahir tanpa sihir di dunia di mana sihir segalanya. " +
                        "Namun, ia tak menyerah dan bertekad menjadi Kaisar Sihir. " +
                        "Dengan kekuatan anti-sihir dan semangat baja, ia terus bertarung. " +
                        "Bersama Yuno, saingannya sejak kecil, ia menghadapi banyak tantangan. " +
                        "Anime ini penuh aksi, rivalitas, dan semangat pantang menyerah."
            )
        )

        listAnime.add(
            ItemAnime(
                R.drawable.april,
                "Your Lie in April",
                "Naoshi Arakawa",
                "Drama, Music, Romance",
                "Kousei Arima kehilangan semangat bermain piano setelah ibunya meninggal. " +
                        "Dunianya berubah saat bertemu Kaori Miyazono, gadis ceria pemain biola. " +
                        "Kaori mengajaknya kembali ke panggung dan menikmati musik dari hati. " +
                        "Namun, di balik senyum Kaori, tersimpan rahasia yang mengharukan. " +
                        "Anime ini menyentuh jiwa dengan kisah cinta, kehilangan, dan harapan."
            )
        )

        listAnime.add(
            ItemAnime(
                R.drawable.jjk,
                "Jujutsu Kaisen",
                "Gege Akutami",
                "Action, Dark Fantasy",
                "Itadori Yuji hidup biasa sampai memakan jari kutukan terlarang Sukuna. " +
                        "Kini ia menjadi wadah iblis terkuat dan belajar di sekolah Jujutsu. " +
                        "Bersama Gojo dan teman-temannya, ia membasmi roh kutukan yang mengancam manusia. " +
                        "Pertarungan intens, kekuatan unik, dan dunia gelap membentuk kisah ini. " +
                        "Jujutsu Kaisen menyajikan aksi brutal dan karakter yang dalam."
            )
        )

        listAnime.add(
            ItemAnime(
                R.drawable.haikyuu,
                "Haikyuu!!",
                "Haruichi Furudate",
                "Sports, Drama, School, Comedy",
                "Hinata Shoyo, pemain voli bertubuh kecil tapi bersemangat besar. " +
                        "Ia bergabung dengan tim Karasuno dan bertemu saingan lamanya, Kageyama. " +
                        "Mereka berdua membentuk duo yang tangguh di lapangan. " +
                        "Setiap pertandingan membawa pelajaran, kerja keras, dan pertumbuhan. " +
                        "Haikyuu!! menyuguhkan semangat olahraga yang membakar jiwa."
            )
        )

        listAnime.add(
            ItemAnime(
                R.drawable.bbysitter,
                "Gakuen Babysitters",
                "Hari Tokeino",
                "Slice of Life, Comedy",
                "Ryuuichi harus menjaga adiknya setelah kehilangan orang tuanya. " +
                        "Ia masuk sekolah yang punya penitipan bayi untuk anak-anak guru. " +
                        "Di sana ia membantu mengasuh bayi-bayi lucu bersama teman barunya. " +
                        "Cerita ringan, menggemaskan, dan menyentuh tentang keluarga dan tanggung jawab. " +
                        "Anime ini cocok untuk yang suka cerita hangat dan manis."
            )
        )

        listAnime.add(
            ItemAnime(
                R.drawable.naruto,
                "Naruto Shippuden",
                "Masashi Kishimoto",
                "Action, Adventure, Ninja",
                "Naruto Uzumaki kembali lebih dewasa untuk menyelamatkan teman-temannya. " +
                        "Ia terus mengejar cita-cita menjadi Hokage, pemimpin desa Konoha. " +
                        "Banyak pertarungan epik, peristiwa emosional, dan pengungkapan rahasia besar. " +
                        "Naruto bertarung melawan organisasi Akatsuki dan menghadapi masa lalunya. " +
                        "Sebuah kisah panjang yang menginspirasi tentang tekad dan persahabatan."
            )
        )

        listAnime.add(
            ItemAnime(
                R.drawable.demon,
                "Kimetsu no Yaiba",
                "Koyoharu Gotouge",
                "Action, Historical, Supernatural",
                "Tanjiro Kamado berjuang menyelamatkan adiknya, Nezuko, yang jadi iblis. " +
                        "Ia bergabung dengan pasukan pembasmi iblis demi menemukan penawar. " +
                        "Pertarungan melawan iblis-iblis bulan atas penuh emosi dan visual memukau. " +
                        "Teknik pernapasan unik dan latar zaman Taisho memperkuat atmosfer anime ini. " +
                        "Kimetsu no Yaiba adalah kisah keluarga, dendam, dan harapan."
            )
        )

        listAnime.add(
            ItemAnime(
                R.drawable.hxh,
                "Hunter x Hunter",
                "Yoshihiro Togashi",
                "Action, Adventure, Fantasy",
                "Gon Freecss memulai perjalanan untuk menjadi Hunter dan menemukan ayahnya. " +
                        "Di sepanjang perjalanan, ia bertemu Kurapika, Leorio, dan Killua. " +
                        "Mereka menghadapi ujian berat, pertarungan berbahaya, dan organisasi gelap. " +
                        "Cerita berkembang ke arah yang gelap dan dalam secara psikologis. " +
                        "Hunter x Hunter adalah perpaduan eksplorasi, kekuatan, dan moralitas."
            )
        )


        // Setup RecyclerView Grid Vertikal
        animeRecyclerView.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        animeAdapter = MyAdapter(listAnime)
        animeRecyclerView.adapter = animeAdapter

        // Setup RecyclerView Horizontal
        val recyclerHorizontal = findViewById<RecyclerView>(R.id.recyclerViewHorizontal)
        recyclerHorizontal.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerHorizontal.adapter = HorizontalAdapter(listAnime)
    }
}
