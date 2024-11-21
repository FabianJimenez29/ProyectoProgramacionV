package com.fabijimenez.proyectoprogramacionv.activities

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.fabijimenez.proyectoprogramacionv.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class BranchesActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_branches)

        val imageButton: ImageButton = findViewById(R.id.imageButton3)

        // Configura el OnClickListener para redirigir a LanguageActivity
        imageButton.setOnClickListener {
            // Crear una intención para iniciar LanguageActivity
            val intent = Intent(this, LanguageActivity::class.java)
            startActivity(intent)
        }

        val wazeIcon = findViewById<ImageView>(R.id.waze_icon_san_sebastian)
        wazeIcon.setOnClickListener {
            // URL de Google Maps
            val url = "https://www.google.com/maps/place/Super+Servicio+San+Sebasti%C3%A1n/@9.9122029,-84.0864305,19z/data=!4m10!1m2!2m1!1sSuper+Servicio!3m6!1s0x8fa0e33952adf795:0x161f753e21eb5b66!8m2!3d9.9119722!4d-84.0854482!15sCg5TdXBlciBTZXJ2aWNpbyIDiAEBkgEKY2FyX3JlcGFpcuABAA!16s%2Fg%2F1pp2vdhbr?entry=ttu&g_ep=EgoyMDI0MTExOC4wIKXMDSoASAFQAw%3D%3D"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)
        }

        val wazeIconLiberia: ImageView = findViewById(R.id.waze_icon_liberia)
        wazeIconLiberia.setOnClickListener {
            val url = "https://www.google.com/maps/place/Super+Servicio+Liberia/@10.6258015,-85.4472649,18z/data=!4m9!1m2!2m1!1sSuper+Servicio!3m5!1s0x8f757d2f2cebe10b:0xe625b9601bab69fe!8m2!3d10.6260595!4d-85.445716!16s%2Fg%2F1tfzhv0q?entry=ttu&g_ep=EgoyMDI0MTExOC4wIKXMDSoASAFQAw%3D%3D"
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
        }

        val wazeIconAvenida10: ImageView = findViewById(R.id.waze_icon_avenida_10)
        wazeIconAvenida10.setOnClickListener {
            val url = "https://www.google.com/maps/place/Super+Servicio+Av.10/@9.9327293,-84.0973753,18z/data=!4m10!1m2!2m1!1sSuper+Servicio!3m6!1s0x8fa0e3427cb77b11:0x6c26fc310f06a403!8m2!3d9.9324835!4d-84.0959642!15sCg5TdXBlciBTZXJ2aWNpbyIDiAEBkgEQYXV0b19yZXBhaXJfc2hvcOABAA!16s%2Fg%2F11ptmcfmyc?entry=ttu&g_ep=EgoyMDI0MTExOC4wIKXMDSoASAFQAw%3D%3D"
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
        }

        val wazeIconEscazu: ImageView = findViewById(R.id.waze_icon_escazu)
        wazeIconEscazu.setOnClickListener {
            val url = "https://www.google.com/maps/place/Super+Servicio/@9.9306219,-84.1511288,20z/data=!4m10!1m2!2m1!1sSuper+Servicio!3m6!1s0x8fa0e33ead2e9533:0xc782b8bc8c2b6eaa!8m2!3d9.930608!4d-84.1505454!15sCg5TdXBlciBTZXJ2aWNpbyIDiAEBkgERYXV0b19tYWNoaW5lX3Nob3DgAQA!16s%2Fg%2F1tg2lqvw?entry=ttu&g_ep=EgoyMDI0MTExOC4wIKXMDSoASAFQAw%3D%3D"
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
        }

        val wazeIconHeredia: ImageView = findViewById(R.id.waze_icon_heredia)
        wazeIconHeredia.setOnClickListener {
            val url = "https://www.google.com/maps/place/S%C3%BAper+Servicio+Heredia/@9.991589,-84.1359924,19z/data=!4m10!1m2!2m1!1sSuper+Servicio!3m6!1s0x8fa0fafb0c8ee11f:0xe02690135abae534!8m2!3d9.9916002!4d-84.1352159!15sCg5TdXBlciBTZXJ2aWNpbyIDiAEBkgEQYXV0b19yZXBhaXJfc2hvcOABAA!16s%2Fg%2F1tjl6zfd?entry=ttu&g_ep=EgoyMDI0MTExOC4wIKXMDSoASAFQAw%3D%3D"
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
        }

        val wazeIconSanIsidro: ImageView = findViewById(R.id.waze_icon_san_isidro)
        wazeIconSanIsidro.setOnClickListener {
            val url = "https://www.google.com/maps/place/Super+Servicio/@9.3776159,-83.7047403,17z/data=!4m6!3m5!1s0x8fa14ec1fe27b5bb:0xef4889196e865c4d!8m2!3d9.3780874!4d-83.7037641!16s%2Fg%2F1tfyfmwr?hl=es-ES&entry=ttu&g_ep=EgoyMDI0MTExOC4wIKXMDSoASAFQAw%3D%3D"
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
        }

        val wazeIconAlajuela: ImageView = findViewById(R.id.waze_icon_alajuela)
        wazeIconAlajuela.setOnClickListener {
            val url = "https://www.google.com/maps/place/Super+Servicio+Alajuela/@10.0160951,-84.2257662,17z/data=!4m10!1m2!2m1!1ssuper+servicio!3m6!1s0x8fa0f9ce8fe34ad5:0xaeab8de570f2cb4e!8m2!3d10.0158469!4d-84.2218691!15sCg5zdXBlciBzZXJ2aWNpbyIDiAEBkgEQYXV0b19yZXBhaXJfc2hvcOABAA!16s%2Fg%2F1thn6kzj?hl=es-ES&entry=ttu&g_ep=EgoyMDI0MTExOC4wIKXMDSoASAFQAw%3D%3D"
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
        }

        val wazeIconCartago: ImageView = findViewById(R.id.waze_icon_cartago)
        wazeIconCartago.setOnClickListener {
            val url = "https://www.google.com/maps/place/Super+Servicio+Cartago/@9.8657983,-83.9254913,19z/data=!4m10!1m2!2m1!1ssuper+servicio!3m6!1s0x8fa0dfe6f0ef4231:0x183107ee44e065ac!8m2!3d9.8659265!4d-83.9245901!15sCg5zdXBlciBzZXJ2aWNpbyIDiAEBkgERYXV0b19tYWNoaW5lX3Nob3DgAQA!16s%2Fg%2F1hdz6m0cc?hl=es-ES&entry=ttu&g_ep=EgoyMDI0MTExOC4wIKXMDSoASAFQAw%3D%3D"
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
        }

        val wazeIconGuapiles: ImageView = findViewById(R.id.waze_icon_guapiles)
        wazeIconGuapiles.setOnClickListener {
            val url = "https://www.google.com/maps/place/Super+Servicio+Gu%C3%A1piles/@10.2022343,-83.7833613,18z/data=!4m10!1m2!2m1!1ssuper+servicio!3m6!1s0x8fa0b80af2192009:0xb847ecc74e576f5c!8m2!3d10.2026289!4d-83.7814087!15sCg5zdXBlciBzZXJ2aWNpbyIDiAEBkgEQYXV0b19yZXBhaXJfc2hvcOABAA!16s%2Fg%2F1tkp0vh_?hl=es-ES&entry=ttu&g_ep=EgoyMDI0MTExOC4wIKXMDSoASAFQAw%3D%3D"
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
        }

        val wazeIconSantaAna: ImageView = findViewById(R.id.waze_icon_santa_ana)
        wazeIconSantaAna.setOnClickListener {
            val url = "https://www.google.com/maps/place/Super+Servicio+Santa+Ana/@9.9312562,-84.182286,18z/data=!4m10!1m2!2m1!1ssuper+servicio!3m6!1s0x8fa0fd15b6e4a209:0x49fa5ecbfef33cfa!8m2!3d9.9312562!4d-84.1799042!15sCg5zdXBlciBzZXJ2aWNpbyIDiAEBkgERYXV0b19tYWNoaW5lX3Nob3DgAQA!16s%2Fg%2F11fsw00bv6?hl=es-ES&entry=ttu&g_ep=EgoyMDI0MTExOC4wIKXMDSoASAFQAw%3D%3D"
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
        }

        val wazeIconAnonos: ImageView = findViewById(R.id.waze_icon_anonos)
        wazeIconAnonos.setOnClickListener {
            val url = "https://www.google.com/maps/place/Super+Servicio+Anonos/@9.9330877,-84.1190615,18z/data=!4m10!1m2!2m1!1ssuper+servicio!3m6!1s0x8fa0fdff5ec39473:0x83bfdd9f3d8ad4c5!8m2!3d9.9330877!4d-84.1166797!15sCg5zdXBlciBzZXJ2aWNpbyIDiAEBkgERYXV0b19tYWNoaW5lX3Nob3DgAQA!16s%2Fg%2F11pbbl9l_d?hl=es-ES&entry=ttu&g_ep=EgoyMDI0MTExOC4wIKXMDSoASAFQAw%3D%3D" // URL correspondiente
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
        }

        val wazeIconCurridabat: ImageView = findViewById(R.id.waze_icon_curridabat)
        wazeIconCurridabat.setOnClickListener {
            val url = "https://www.google.com/maps/place/Super+Servicio+Curridabat/@9.9215115,-84.0388215,18z/data=!4m10!1m2!2m1!1ssuper+servicio!3m6!1s0x8fa0e397453194d9:0xbc894c2b28da8428!8m2!3d9.9215115!4d-84.0364397!15sCg5zdXBlciBzZXJ2aWNpbyIDiAEBkgEQYXV0b19yZXBhaXJfc2hvcOABAA!16s%2Fg%2F11w8dtjz5l?hl=es-ES&entry=ttu&g_ep=EgoyMDI0MTExOC4wIKXMDSoASAFQAw%3D%3D" // URL correspondiente
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
        }

        val wazeIconMangoPlaza: ImageView = findViewById(R.id.waze_icon_mango_plaza)
        wazeIconMangoPlaza.setOnClickListener {
            val url = "https://www.google.com/maps/place/S%C3%BAper+Servicio+%E2%80%A2+R%C3%ADo+Segundo/@10.002524,-84.2099631,18z/data=!4m10!1m2!2m1!1ssuper+servicio!3m6!1s0x8fa0f9fcda296e6d:0xc85fc6eaadc94264!8m2!3d10.002524!4d-84.2075813!15sCg5zdXBlciBzZXJ2aWNpbyIDiAEBkgERYXV0b19tYWNoaW5lX3Nob3DgAQA!16s%2Fg%2F11pbbkjdgd?hl=es-ES&entry=ttu&g_ep=EgoyMDI0MTExOC4wIKXMDSoASAFQAw%3D%3D" // URL correspondiente
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
        }



        val telefonoIconAvenida10: ImageView = findViewById(R.id.telefono_icon_avenida_10)
        telefonoIconAvenida10.setOnClickListener {
            val phoneIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:+5064032-3521"))
            startActivity(phoneIntent)
        }

        val telefonoIconSanSebastian: ImageView = findViewById(R.id.telefono_icon_san_sebastian)
        telefonoIconSanSebastian.setOnClickListener {
            val phoneIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:+5064032-3522"))
            startActivity(phoneIntent)
        }

        val telefonoIconEscazu: ImageView = findViewById(R.id.telefono_icon_escazu)
        telefonoIconEscazu.setOnClickListener {
            val phoneIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:+5064032-3523"))
            startActivity(phoneIntent)
        }

        val telefonoIconHeredia: ImageView = findViewById(R.id.telefono_icon_heredia)
        telefonoIconHeredia.setOnClickListener {
            val phoneIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:+5064032-3525"))
            startActivity(phoneIntent)
        }

        val telefonoIconSanIsidro: ImageView = findViewById(R.id.telefono_icon_san_isidro)
        telefonoIconSanIsidro.setOnClickListener {
            val phoneIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:+5064032-3527"))
            startActivity(phoneIntent)
        }

        val telefonoIconLiberia: ImageView = findViewById(R.id.telefono_icon_liberia)
        telefonoIconLiberia.setOnClickListener {
            val phoneIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:+5064032-3530"))
            startActivity(phoneIntent)
        }

        val telefonoIconAlajuela: ImageView = findViewById(R.id.telefono_icon_alajuela)
        telefonoIconAlajuela.setOnClickListener {
            val phoneIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:+5064032-3526"))
            startActivity(phoneIntent)
        }

        val telefonoIconCartago: ImageView = findViewById(R.id.telefono_icon_cartago)
        telefonoIconCartago.setOnClickListener {
            val phoneIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:+5064032-3524"))
            startActivity(phoneIntent)
        }

        val telefonoIconGuapiles: ImageView = findViewById(R.id.telefono_icon_guapiles)
        telefonoIconGuapiles.setOnClickListener {
            val phoneIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:+5064032-3529"))
            startActivity(phoneIntent)
        }

        val telefonoIconSantaAna: ImageView = findViewById(R.id.telefono_icon_santa_ana)
        telefonoIconSantaAna.setOnClickListener {
            val phoneIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:+5064032-3506"))
            startActivity(phoneIntent)
        }

        val telefonoIconMangoPlaza: ImageView = findViewById(R.id.telefono_icon_mango_plaza)
        telefonoIconMangoPlaza.setOnClickListener {
            val phoneIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:+5064032-3534"))
            startActivity(phoneIntent)
        }

        val telefonoIconAnonos: ImageView = findViewById(R.id.telefono_icon_anonos)
        telefonoIconAnonos.setOnClickListener {
            val phoneIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:+5064032-3509"))
            startActivity(phoneIntent)
        }

        val telefonoIconCurridabat: ImageView = findViewById(R.id.telefono_icon_curridabat)
        telefonoIconCurridabat.setOnClickListener {
            val phoneIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:+5064032-3535"))
            startActivity(phoneIntent)
        }









        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    // Solo navega si la actividad actual no es la misma
                    if (javaClass != MainActivity::class.java) {
                        startActivity(Intent(this, MainActivity::class.java))
                    }
                    true
                }
                R.id.nav_store -> {
                    // Solo navega si la actividad actual no es la misma
                    if (javaClass != ShopActivity::class.java) {
                        startActivity(Intent(this, ShopActivity::class.java))
                    }
                    true
                }
                R.id.nav_profile -> {
                    // Solo navega si la actividad actual no es la misma
                    if (javaClass != ProfileActivity::class.java) {
                        startActivity(Intent(this, ProfileActivity::class.java))
                    }
                    true
                }
                R.id.nav_branches -> {
                    // Solo navega si la actividad actual no es la misma
                    if (javaClass != BranchesActivity::class.java) {
                        startActivity(Intent(this, BranchesActivity::class.java))
                    }
                    true
                }
                R.id.nav_contact -> {
                    // Solo navega si la actividad actual no es la misma
                    if (javaClass != ContactActivity::class.java) {
                        startActivity(Intent(this, ContactActivity::class.java))
                    }
                    true
                }
                else -> false
            }
        }


        bottomNavigationView.selectedItemId = R.id.nav_branches
    }

}