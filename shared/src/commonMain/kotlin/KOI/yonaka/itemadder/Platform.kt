package KOI.yonaka.itemadder

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform