package bankingSystem

data class Account(var userName:String, var password:String, var userType:String, var Approved:Boolean = false, var balance:Double = 0.0, var History:ArrayList<ArrayList<String>> = ArrayList()): java.io.Serializable{

    fun withdraw(amount:Double){
        this.balance -= amount
        val recording:ArrayList<String> = arrayListOf("withdraw",amount.toString(),Time.time())
        this.History.add(recording)
        AccessObjectFile.writeToFile(this.userName+".ser",this)
        println("withdrew $amount to ${this.userName}")
    }

    fun deposit(amount:Double){
        this.balance += amount
        val recording:ArrayList<String> = arrayListOf("deposit",amount.toString(),Time.time())
        this.History.add(recording)
        AccessObjectFile.writeToFile(this.userName+".ser",this)
        println("deposited $amount to ${this.userName}")
    }

    fun transfer(amount:Double, target:String){
        this.balance -= amount
        val recording:ArrayList<String> = arrayListOf("transfer",amount.toString(),target,Time.time())
        this.History.add(recording)
        AccessObjectFile.writeToFile(this.userName+".ser",this)
        println("transferred $amount to $target")

        //call target object file
        val targetObject = AccessObjectFile.readFromFile("$target.ser")
        targetObject.receiveTransfer(amount,this.userName)
        AccessObjectFile.writeToFile("$target.ser",targetObject)
    }

    fun receiveTransfer(amount: Double,sender:String){
        this.balance += amount
        val recording:ArrayList<String> = arrayListOf("receive",amount.toString(),sender,Time.time())
        this.History.add(recording)
        println("received $amount from $sender")
    }


}