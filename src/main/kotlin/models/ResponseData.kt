package src.models

open class ResponseData {
    lateinit var NodeServers: Array<String>
    @JvmField
    var RespMessage: String? = null
    @JvmField
    var RespCode: Int? = null
    var Data: Map<String, Any>? = null
    var Balance:Float? = null
    lateinit var NodeWallets: Array<WalletSyncData>

}

class GenericResponseData: ResponseData() {
    var message : String?=null
}