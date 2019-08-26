package com.don.bottomsheetonfragment

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.ViewPager
import android.util.Log
import com.don.bottomsheetonfragment.fragment.RightFragment
import com.don.bottomsheetonfragment.mdl.ContentItem
import com.don.bottomsheetonfragment.mdl.ItemsItem
import com.don.bottomsheetonfragment.mdl.MdlStick
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {


    lateinit var tabLayout: TabLayout
    lateinit var viewPager: ViewPager
    var dataList: MutableList<ItemsItem> = mutableListOf()
    var contentItems: MutableList<ContentItem> = mutableListOf()
    val jsonString = "{\n" +
            "  \"data\": [\n" +
            "    {\n" +
            "      \"type\": 2,\n" +
            "      \"title\": \"News\",\n" +
            "      \"content\": [\n" +
            "        {\n" +
            "          \"category_id\": 1,\n" +
            "          \"category_name\": \"Top News\",\n" +
            "          \"items\": [\n" +
            "            {\n" +
            "              \"id\": 1,\n" +
            "              \"content_category\": \"Top News\",\n" +
            "              \"title\": \"Satwa liar masuk ke permukiman akibat terdesak kebakaran lahan\",\n" +
            "              \"pubDate\": \"2019-08-20 16:41:44\",\n" +
            "              \"link\": \"https://www.antaranews.com/berita/1021468/satwa-liar-masuk-ke-permukiman-akibat-terdesak-kebakaran-lahan\",\n" +
            "              \"guid\": \"https://www.antaranews.com/berita/1021468/satwa-liar-masuk-ke-permukiman-akibat-terdesak-kebakaran-lahan\",\n" +
            "              \"author\": \"\",\n" +
            "              \"thumbnail\": \"https://img.antaranews.com/cache/255x170/2019/08/20/Karhutla_Kotim.jpg\",\n" +
            "              \"description\": \"<img src=\\\"https://img.antaranews.com/cache/255x170/2019/08/20/Karhutla_Kotim.jpg\\\" align=\\\"left\\\" border=\\\"0\\\">Kebakaran lahan yang terjadi di banyak tempat di Kabupaten Kotawaringin Timur, Kalimantan Tengah, dalam dua bulan terakhir memaksa satwa liar menyelamatkan diri, bahkan ada yang sampai masuk ke kebun dan permukiman ...\",\n" +
            "              \"content\": \"<img src=\\\"https://img.antaranews.com/cache/255x170/2019/08/20/Karhutla_Kotim.jpg\\\" align=\\\"left\\\" border=\\\"0\\\">Kebakaran lahan yang terjadi di banyak tempat di Kabupaten Kotawaringin Timur, Kalimantan Tengah, dalam dua bulan terakhir memaksa satwa liar menyelamatkan diri, bahkan ada yang sampai masuk ke kebun dan permukiman ...\",\n" +
            "              \"enclosure_link\": \"\",\n" +
            "              \"enclosure_type\": \"\",\n" +
            "              \"enclosure_length\": \"\",\n" +
            "              \"status_show\": 1,\n" +
            "              \"status_name\": \"Showing\"\n" +
            "            }\n" +
            "          ]\n" +
            "        },\n" +
            "        {\n" +
            "          \"category_id\": 2,\n" +
            "          \"category_name\": \"Metro\",\n" +
            "          \"items\": [\n" +
            "            {\n" +
            "              \"id\": 21,\n" +
            "              \"content_category\": \"Metro\",\n" +
            "              \"title\": \"DKI Jakarta bagi 800 kartu Jak Lingko gratis\",\n" +
            "              \"pubDate\": \"2019-08-20 17:09:26\",\n" +
            "              \"link\": \"https://www.antaranews.com/berita/1021560/dki-jakarta-bagi-800-kartu-jak-lingko-gratis\",\n" +
            "              \"guid\": \"https://www.antaranews.com/berita/1021560/dki-jakarta-bagi-800-kartu-jak-lingko-gratis\",\n" +
            "              \"author\": \"\",\n" +
            "              \"thumbnail\": \"https://img.antaranews.com/cache/255x170/2019/08/07/IMG-20190220-WA0226-800x534.jpg\",\n" +
            "              \"description\": \"<img src=\\\"https://img.antaranews.com/cache/255x170/2019/08/07/IMG-20190220-WA0226-800x534.jpg\\\" align=\\\"left\\\" border=\\\"0\\\">Pemerintah Provinsi DKI Jakarta yang kini tengah gencar mengkampanyekan penggunaan transportasi publik, menggelontorkan 800 kartu Jak Lingko&nbsp;gratis melalui&nbsp; program Jak Lingko Goes To School.\\r\\n\\r\\n&quot;Kegiatan ini ...\",\n" +
            "              \"content\": \"<img src=\\\"https://img.antaranews.com/cache/255x170/2019/08/07/IMG-20190220-WA0226-800x534.jpg\\\" align=\\\"left\\\" border=\\\"0\\\">Pemerintah Provinsi DKI Jakarta yang kini tengah gencar mengkampanyekan penggunaan transportasi publik, menggelontorkan 800 kartu Jak Lingko&nbsp;gratis melalui&nbsp; program Jak Lingko Goes To School.\\r\\n\\r\\n&quot;Kegiatan ini ...\",\n" +
            "              \"enclosure_link\": \"\",\n" +
            "              \"enclosure_type\": \"\",\n" +
            "              \"enclosure_length\": \"\",\n" +
            "              \"status_show\": 1,\n" +
            "              \"status_name\": \"Showing\"\n" +
            "            }\n" +
            "          ]\n" +
            "        },\n" +
            "        {\n" +
            "          \"category_id\": 4,\n" +
            "          \"category_name\": \"Bussiness\",\n" +
            "          \"items\": [\n" +
            "            {\n" +
            "              \"id\": 135,\n" +
            "              \"content_category\": \"Bussiness\",\n" +
            "              \"title\": \"Menteri Milenial Bicara Peluang Gojek Mengaspal di Malaysia\",\n" +
            "              \"pubDate\": \"2019-08-20 14:14:30\",\n" +
            "              \"link\": \"https://inet.detik.com/read/2019/08/20/134808/4673363/319/menteri-milenial-bicara-peluang-gojek-mengaspal-di-malaysia\",\n" +
            "              \"guid\": \"https://inet.detik.com/read/2019/08/20/134808/4673363/319/menteri-milenial-bicara-peluang-gojek-mengaspal-di-malaysia\",\n" +
            "              \"author\": \"\",\n" +
            "              \"thumbnail\": \"https://akcdn.detik.net.id/visual/2019/07/22/8908e55b-4c9d-40df-b0f7-73bfd68092b3_169.jpeg\",\n" +
            "              \"description\": \"<img src=\\\"https://akcdn.detik.net.id/visual/2019/07/22/8908e55b-4c9d-40df-b0f7-73bfd68092b3_169.jpeg\\\" align=\\\"left\\\" hspace=\\\"7\\\" width=\\\"100\\\" />Gojek tampaknya bakal ekspansi ke Malaysia, yang diketahui dari postingan Instagram Menteri Pemuda dan Olahraga Malaysia Syed Saddiq Syed Abdul Rahman.\",\n" +
            "              \"content\": \"<img src=\\\"https://akcdn.detik.net.id/visual/2019/07/22/8908e55b-4c9d-40df-b0f7-73bfd68092b3_169.jpeg\\\" align=\\\"left\\\" hspace=\\\"7\\\" width=\\\"100\\\" />Gojek tampaknya bakal ekspansi ke Malaysia, yang diketahui dari postingan Instagram Menteri Pemuda dan Olahraga Malaysia Syed Saddiq Syed Abdul Rahman.\",\n" +
            "              \"enclosure_link\": \"https://akcdn.detik.net.id/visual/2019/07/22/8908e55b-4c9d-40df-b0f7-73bfd68092b3_169.jpeg\",\n" +
            "              \"enclosure_type\": \"image/jpeg\",\n" +
            "              \"enclosure_length\": \"10240\",\n" +
            "              \"status_show\": 1,\n" +
            "              \"status_name\": \"Showing\"\n" +
            "            }\n" +
            "          ]\n" +
            "        },\n" +
            "        {\n" +
            "          \"category_id\": 5,\n" +
            "          \"category_name\": \"Technology\",\n" +
            "          \"items\": [\n" +
            "            \n" +
            "          ]\n" +
            "        },\n" +
            "        {\n" +
            "          \"category_id\": 6,\n" +
            "          \"category_name\": \"Sports\",\n" +
            "          \"items\": [\n" +
            "            {\n" +
            "              \"id\": 60,\n" +
            "              \"content_category\": \"Sports\",\n" +
            "              \"title\": \"Gregoria melaju ke putaran ketiga Kejuaraan Dunia\",\n" +
            "              \"pubDate\": \"2019-08-20 17:10:38\",\n" +
            "              \"link\": \"https://www.antaranews.com/berita/1021564/gregoria-melaju-ke-putaran-ketiga-kejuaraan-dunia\",\n" +
            "              \"guid\": \"https://www.antaranews.com/berita/1021564/gregoria-melaju-ke-putaran-ketiga-kejuaraan-dunia\",\n" +
            "              \"author\": \"\",\n" +
            "              \"thumbnail\": \"https://img.antaranews.com/cache/255x170/2019/07/25/greg1.jpg\",\n" +
            "              \"description\": \"<img src=\\\"https://img.antaranews.com/cache/255x170/2019/07/25/greg1.jpg\\\" align=\\\"left\\\" border=\\\"0\\\">Tunggal putri unggulan 14 Gregoria Mariska Tunjung melaju ke putaran ketiga Kejuaraan Dunia Bulu Tangkis BWF setelah mengalahkan pemain Thailand Busanan Ongbamrungphan 21-14, 21-10.\\r\\n\\r\\nDalam pertandingan yang digelar di St. ...\",\n" +
            "              \"content\": \"<img src=\\\"https://img.antaranews.com/cache/255x170/2019/07/25/greg1.jpg\\\" align=\\\"left\\\" border=\\\"0\\\">Tunggal putri unggulan 14 Gregoria Mariska Tunjung melaju ke putaran ketiga Kejuaraan Dunia Bulu Tangkis BWF setelah mengalahkan pemain Thailand Busanan Ongbamrungphan 21-14, 21-10.\\r\\n\\r\\nDalam pertandingan yang digelar di St. ...\",\n" +
            "              \"enclosure_link\": \"\",\n" +
            "              \"enclosure_type\": \"\",\n" +
            "              \"enclosure_length\": \"\",\n" +
            "              \"status_show\": 1,\n" +
            "              \"status_name\": \"Showing\"\n" +
            "            }\n" +
            "          ]\n" +
            "        },\n" +
            "        {\n" +
            "          \"category_id\": 7,\n" +
            "          \"category_name\": \"Automotive\",\n" +
            "          \"items\": [\n" +
            "            {\n" +
            "              \"id\": 77,\n" +
            "              \"content_category\": \"Automotive\",\n" +
            "              \"title\": \"Huawei, Qilu akan bangun jalan raya khusus uji coba swakemudi\",\n" +
            "              \"pubDate\": \"2019-08-20 14:15:34\",\n" +
            "              \"link\": \"https://otomotif.antaranews.com/berita/1021162/huawei-qilu-akan-bangun-jalan-raya-khusus-uji-coba-swakemudi\",\n" +
            "              \"guid\": \"https://otomotif.antaranews.com/berita/1021162/huawei-qilu-akan-bangun-jalan-raya-khusus-uji-coba-swakemudi\",\n" +
            "              \"author\": \"\",\n" +
            "              \"thumbnail\": \"https://img.antaranews.com/cache/255x170/2019/08/20/shutterstock_1027959058_1.jpg\",\n" +
            "              \"description\": \"<img src=\\\"https://img.antaranews.com/cache/255x170/2019/08/20/shutterstock_1027959058_1.jpg\\\" align=\\\"left\\\" border=\\\"0\\\">Pengembang transportasi China, Qilu, bersama raksasa teknologi Huawei akan membangun jalan raya khusus sebagai arena uji coba kendaraan swakemudi (self-driving), untuk mengantisipasi perkembangan teknologi mobilitas Google, ...\",\n" +
            "              \"content\": \"<img src=\\\"https://img.antaranews.com/cache/255x170/2019/08/20/shutterstock_1027959058_1.jpg\\\" align=\\\"left\\\" border=\\\"0\\\">Pengembang transportasi China, Qilu, bersama raksasa teknologi Huawei akan membangun jalan raya khusus sebagai arena uji coba kendaraan swakemudi (self-driving), untuk mengantisipasi perkembangan teknologi mobilitas Google, ...\",\n" +
            "              \"enclosure_link\": \"\",\n" +
            "              \"enclosure_type\": \"\",\n" +
            "              \"enclosure_length\": \"\",\n" +
            "              \"status_show\": 1,\n" +
            "              \"status_name\": \"Showing\"\n" +
            "            }\n" +
            "          ]\n" +
            "        },\n" +
            "        {\n" +
            "          \"category_id\": 8,\n" +
            "          \"category_name\": \"Lifestyle\",\n" +
            "          \"items\": [\n" +
            "            {\n" +
            "              \"id\": 95,\n" +
            "              \"content_category\": \"Lifestyle\",\n" +
            "              \"title\": \"Hari ini, Cine-macet hingga festival kuliner\",\n" +
            "              \"pubDate\": \"2019-08-20 07:11:24\",\n" +
            "              \"link\": \"https://www.antaranews.com/berita/1020612/hari-ini-cine-macet-hingga-festival-kuliner\",\n" +
            "              \"guid\": \"https://www.antaranews.com/berita/1020612/hari-ini-cine-macet-hingga-festival-kuliner\",\n" +
            "              \"author\": \"\",\n" +
            "              \"thumbnail\": \"https://img.antaranews.com/cache/255x170/2019/04/24/IMG_20181219_063957-800x534.jpg\",\n" +
            "              \"description\": \"<img src=\\\"https://img.antaranews.com/cache/255x170/2019/04/24/IMG_20181219_063957-800x534.jpg\\\" align=\\\"left\\\" border=\\\"0\\\">Berikut adalah beberapa agenda pilihan yang berlangsung hari ini di Jakarta.\\r\\n\\r\\n1. Cine-macet: &quot;Nothern Wind&quot;\\r\\nFilm drama Prancis ini diputar di IFI Thamrin pada pukul 19.00 WIB dengan harga tiket masuk sebesar Rp20 ...\",\n" +
            "              \"content\": \"<img src=\\\"https://img.antaranews.com/cache/255x170/2019/04/24/IMG_20181219_063957-800x534.jpg\\\" align=\\\"left\\\" border=\\\"0\\\">Berikut adalah beberapa agenda pilihan yang berlangsung hari ini di Jakarta.\\r\\n\\r\\n1. Cine-macet: &quot;Nothern Wind&quot;\\r\\nFilm drama Prancis ini diputar di IFI Thamrin pada pukul 19.00 WIB dengan harga tiket masuk sebesar Rp20 ...\",\n" +
            "              \"enclosure_link\": \"\",\n" +
            "              \"enclosure_type\": \"\",\n" +
            "              \"enclosure_length\": \"\",\n" +
            "              \"status_show\": 1,\n" +
            "              \"status_name\": \"Showing\"\n" +
            "            }\n" +
            "          ]\n" +
            "        },\n" +
            "        {\n" +
            "          \"category_id\": 9,\n" +
            "          \"category_name\": \"Entertainment\",\n" +
            "          \"items\": [\n" +
            "            {\n" +
            "              \"id\": 115,\n" +
            "              \"content_category\": \"Entertainment\",\n" +
            "              \"title\": \"Red Velvet rilis album baru dengan lagu andalan \\\"Umpah Umpah\\\"\",\n" +
            "              \"pubDate\": \"2019-08-20 17:05:29\",\n" +
            "              \"link\": \"https://www.antaranews.com/berita/1021554/red-velvet-rilis-album-baru-dengan-lagu-andalan-umpah-umpah\",\n" +
            "              \"guid\": \"https://www.antaranews.com/berita/1021554/red-velvet-rilis-album-baru-dengan-lagu-andalan-umpah-umpah\",\n" +
            "              \"author\": \"\",\n" +
            "              \"thumbnail\": \"https://img.antaranews.com/cache/255x170/2018/11/reval.jpg\",\n" +
            "              \"description\": \"<img src=\\\"https://img.antaranews.com/cache/255x170/2018/11/reval.jpg\\\" align=\\\"left\\\" border=\\\"0\\\">Grup K-pop Red Velvet merilis &quot;The ReVe Festival: Day 2&quot;, album mini kedua mereka untuk musim panas tahun ini.\\r\\n\\r\\nAlbum tersebut menghadirkan lagu utama berjudul &quot;Umpah Umpah&quot; dengan nuansa disko yang ceria. ...\",\n" +
            "              \"content\": \"<img src=\\\"https://img.antaranews.com/cache/255x170/2018/11/reval.jpg\\\" align=\\\"left\\\" border=\\\"0\\\">Grup K-pop Red Velvet merilis &quot;The ReVe Festival: Day 2&quot;, album mini kedua mereka untuk musim panas tahun ini.\\r\\n\\r\\nAlbum tersebut menghadirkan lagu utama berjudul &quot;Umpah Umpah&quot; dengan nuansa disko yang ceria. ...\",\n" +
            "              \"enclosure_link\": \"\",\n" +
            "              \"enclosure_type\": \"\",\n" +
            "              \"enclosure_length\": \"\",\n" +
            "              \"status_show\": 1,\n" +
            "              \"status_name\": \"Showing\"\n" +
            "            }\n" +
            "          ]\n" +
            "        },\n" +
            "        {\n" +
            "          \"category_id\": 10,\n" +
            "          \"category_name\": \"Health\",\n" +
            "          \"items\": [\n" +
            "            {\n" +
            "              \"id\": 155,\n" +
            "              \"content_category\": \"Health\",\n" +
            "              \"title\": \"Pemeran 'Seks Gangbang' Positif HIV, Ini yang Perlu Dilakukan Usai Diagnosis\",\n" +
            "              \"pubDate\": \"2019-08-20 17:11:21\",\n" +
            "              \"link\": \"https://health.detik.com/read/2019/08/20/170221/4673656/763/pemeran-seks-gangbang-positif-hiv-ini-yang-perlu-dilakukan-usai-diagnosis\",\n" +
            "              \"guid\": \"https://health.detik.com/read/2019/08/20/170221/4673656/763/pemeran-seks-gangbang-positif-hiv-ini-yang-perlu-dilakukan-usai-diagnosis\",\n" +
            "              \"author\": \"\",\n" +
            "              \"thumbnail\": \"https://akcdn.detik.net.id/visual/2019/06/05/af36a81e-01d4-4331-849b-b1324d37e481_169.jpeg\",\n" +
            "              \"description\": \"<img src=\\\"https://akcdn.detik.net.id/visual/2019/06/05/af36a81e-01d4-4331-849b-b1324d37e481_169.jpeg\\\" align=\\\"left\\\" hspace=\\\"7\\\" width=\\\"100\\\" />Bos salon kasus video 'seks gangbang' Garut diketahui positif mengidap HIV. Ketahui beberapa hal yang harus dilakukan apabila positif terdiagnosis HIV.\",\n" +
            "              \"content\": \"<img src=\\\"https://akcdn.detik.net.id/visual/2019/06/05/af36a81e-01d4-4331-849b-b1324d37e481_169.jpeg\\\" align=\\\"left\\\" hspace=\\\"7\\\" width=\\\"100\\\" />Bos salon kasus video 'seks gangbang' Garut diketahui positif mengidap HIV. Ketahui beberapa hal yang harus dilakukan apabila positif terdiagnosis HIV.\",\n" +
            "              \"enclosure_link\": \"https://akcdn.detik.net.id/visual/2019/06/05/af36a81e-01d4-4331-849b-b1324d37e481_169.jpeg\",\n" +
            "              \"enclosure_type\": \"image/jpeg\",\n" +
            "              \"enclosure_length\": \"10240\",\n" +
            "              \"status_show\": 1,\n" +
            "              \"status_name\": \"Showing\"\n" +
            "            }\n" +
            "          ]\n" +
            "        },\n" +
            "        {\n" +
            "          \"category_id\": 11,\n" +
            "          \"category_name\": \"Cooking\",\n" +
            "          \"items\": [\n" +
            "            \n" +
            "          ]\n" +
            "        }\n" +
            "      ]\n" +
            "    }\n" +
            "  ]\n" +
            "  \n" +
            "}"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tabLayout = findViewById(R.id.tabs_example)
        viewPager = findViewById(R.id.viewpager_example)

        val gson = Gson()
        val json = gson.fromJson(jsonString, MdlStick::class.java)
        Log.d("wtf", "" + json.data?.get(0)!!.title)
        contentItems = json.data[0].content as MutableList<ContentItem>


        setupViewPager(viewPager)
        tabLayout.setupWithViewPager(viewPager)

//        viewPager.setCurrentItem(0)
    }


    private fun setupViewPager(viewPager: ViewPager) {
        val adapter = ViewPagerAdapter(supportFragmentManager)

        if (contentItems.size > 0) {
            for (i in 0 until contentItems.size) {
                if (!contentItems[i].categoryName.isNullOrEmpty()){
                    adapter.addFragment(RightFragment(contentItems[i].items), contentItems[i].categoryName!!)
                }
            }
        }

        Log.e("SIZE"," size list " +contentItems.size)


        viewPager.adapter = adapter
    }

    internal inner class ViewPagerAdapter(manager: FragmentManager) : FragmentPagerAdapter(manager) {
        private val mFragmentList = ArrayList<Fragment>()
        private val mFragmentTitleList = ArrayList<String>()
        private val mBundle = Bundle()

        override fun getItem(position: Int): Fragment {
            return mFragmentList.get(position)
        }

        override fun getCount(): Int {
            return mFragmentList.size
        }

        fun addFragment(fragment: Fragment, title: String) {
            mFragmentList.add(fragment)
            mFragmentTitleList.add(title)
//            mFragmentCategoryList.addAll(itemsItem)
        }

        override fun getPageTitle(position: Int): CharSequence {
            return mFragmentTitleList[position]
        }
    }

}
