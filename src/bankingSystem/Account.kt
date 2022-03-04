package bankingSystem

data class Account(var userName:String,var password:String,var userType:String, var History:ArrayList<ArrayList<String>> = ArrayList()): java.io.Serializable{


}