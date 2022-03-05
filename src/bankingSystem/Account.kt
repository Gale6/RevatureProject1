package bankingSystem

data class Account(var userName:String, var password:String, var userType:String, var Approved:Boolean = false, var balance:Double = 0.0, var History:ArrayList<ArrayList<String>> = ArrayList()): java.io.Serializable{

    fun withdraw(amount:Double){
        this.balance -= amount
        val recording:ArrayList<String> = arrayListOf("withdraw",amount.toString(),Time.time())
        this.History.add(recording)
    }

    fun deposit(amount:Double){
        this.balance += amount
        val recording:ArrayList<String> = arrayListOf("deposit",amount.toString(),Time.time())
        this.History.add(recording)
    }

    fun transfer(amount:Double, target:String){
        this.balance -= amount
    }

    fun receiveTransfer(amount: Double,sender:String){
        //TODO
    }


}