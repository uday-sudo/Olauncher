package app.olauncher.data

object Constants {

    object Key {
        const val FLAG = "flag"
        const val RENAME = "rename"
    }

    object Dialog {
        const val RATE = "RATE"
        const val SHARE = "SHARE"
        const val HIDDEN = "HIDDEN"
        const val KEYBOARD = "KEYBOARD"
    }

    object DateTime {
        const val OFF = 0
        const val ON = 1
        const val DATE_ONLY = 2

        fun isTimeVisible(dateTimeVisibility: Int): Boolean {
            return dateTimeVisibility == ON
        }

        fun isDateVisible(dateTimeVisibility: Int): Boolean {
            return dateTimeVisibility == ON || dateTimeVisibility == DATE_ONLY
        }
    }

    object SwipeDownAction {
        const val SEARCH = 1
        const val NOTIFICATIONS = 2
    }

    object TextSize {
        const val ONE = 0.7f
        const val TWO = 0.8f
        const val THREE = 0.9f
        const val FOUR = 1f
        const val FIVE = 1.1f
        const val SIX = 1.2f
        const val SEVEN = 1.3f
    }

    object Font {
        const val font1 = "blackopsone"
        const val font2 = "caveat"
        const val font3 = "dancingscript"
        const val font4 = "heebo"
        const val font5 = "hindisiliguri"
        const val font6 = "lobster"
        const val font7 = "pacifico"
        const val font8 = "pixelifysans"
        const val font9 = "questrial"
        const val font10 = "roboto"
        const val font11 = "yujihentaiganaakari"
    }

    const val WALL_TYPE_LIGHT = "light"
    const val WALL_TYPE_DARK = "dark"

//    const val THEME_MODE_DARK = 0
//    const val THEME_MODE_LIGHT = 1
//    const val THEME_MODE_SYSTEM = 2

    const val FLAG_LAUNCH_APP = 100
    const val FLAG_HIDDEN_APPS = 101

    const val FLAG_SET_HOME_APP_1 = 1
    const val FLAG_SET_HOME_APP_2 = 2
    const val FLAG_SET_HOME_APP_3 = 3
    const val FLAG_SET_HOME_APP_4 = 4
    const val FLAG_SET_HOME_APP_5 = 5
    const val FLAG_SET_HOME_APP_6 = 6
    const val FLAG_SET_HOME_APP_7 = 7
    const val FLAG_SET_HOME_APP_8 = 8

    const val FLAG_SET_HOME_ICON_1 = -1
    const val FLAG_SET_HOME_ICON_2 = -2
    const val FLAG_SET_HOME_ICON_3 = -3
    const val FLAG_SET_HOME_ICON_4 = -4
    const val FLAG_SET_HOME_ICON_5 = -5
    const val FLAG_SET_HOME_ICON_6 = -6
    const val FLAG_SET_HOME_ICON_7 = -7
    const val FLAG_SET_HOME_ICON_8 = -8

    const val FLAG_SET_SWIPE_LEFT_APP = 11
    const val FLAG_SET_SWIPE_RIGHT_APP = 12
    const val FLAG_SET_CLOCK_APP = 13
    const val FLAG_SET_CALENDAR_APP = 14

    const val IC_CAMERA = "ic_camera"
    const val IC_CIRCLE = "ic_circle"
    const val IC_GALLERY = "ic_gallery"
    const val IC_MAIL = "ic_mail"
    const val IC_MESSAGE = "ic_message"
    const val IC_MUSIC = "ic_music"
    const val IC_PHONE = "ic_phone"
    const val IC_SEARCH = "ic_search"
    const val IC_WEB = "ic_web"

    const val REQUEST_CODE_ENABLE_ADMIN = 666
    const val REQUEST_CODE_LAUNCHER_SELECTOR = 678

    const val HINT_RATE_US = 15
    const val HINT_SHARE = 25

    const val LONG_PRESS_DELAY_MS = 500L

    const val URL_ABOUT_OLAUNCHER = "https://gist.github.com/uday-sudo/d30fc6de6d60ebc2891846e798c6f153"
    const val URL_OLAUNCHER_PRIVACY = "https://gist.github.com/uday-sudo/992a8969d63059163838f374e915a6ce"
    const val URL_DOUBLE_TAP = "https://gist.github.com/uday-sudo/f4193d6a08f6ec0519f5d6c13ff3777c"
    const val URL_OLAUNCHER_GITHUB = "https://www.github.com/uday-sudo/Olauncher"
    const val URL_OLAUNCHER_PLAY_STORE = "No avaiable yet" //"https://play.google.com/store/apps/details?id=app.olauncher"
    //const val URL_PLAY_STORE_DEV = "https://play.google.com/store/apps/dev?id=7198807840081074933"
    const val URL_BMAC = "https://www.buymeacoffee.com/uday101"
    const val URL_GITHUB_UDAY = "https://github.com/uday-sudo"
    const val URL_WALLPAPERS = "https://gist.github.com/uday-sudo/33ace778e5152462a3468915db75dd38/raw"
    const val URL_DEFAULT_DARK_WALLPAPER = "https://images.unsplash.com/photo-1512551980832-13df02babc9e"
    const val URL_DEFAULT_LIGHT_WALLPAPER = "https://images.unsplash.com/photo-1515549832467-8783363e19b6"
    const val URL_DUCK_SEARCH = "https://duck.co/?q="

    const val WALLPAPER_WORKER_NAME = "WALLPAPER_WORKER_NAME"
}