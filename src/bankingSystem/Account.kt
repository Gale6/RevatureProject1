package bankingSystem

data class Account(var userName:String,var password:String,var userType:String, var Approved:Boolean = false,var balance:Double = 0.0, var History:ArrayList<ArrayList<String>> = ArrayList()): java.io.Serializable{


}