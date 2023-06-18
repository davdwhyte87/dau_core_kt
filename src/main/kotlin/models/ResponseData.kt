package src.models

open class ResponseData {
    lateinit var nodeServers: Array<String>
    @JvmField
    var respMessage: String? = null
    @JvmField
    var respCode: Int? = null
    var data: Map<String, Any>? = null
    var balance:Float? = null
    lateinit var nodeWallets: Array<WalletSyncData>

}

class GenericResponseData: ResponseData() {
    var message : String?=null
}