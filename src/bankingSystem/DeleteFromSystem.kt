package bankingSystem

import java.io.File

class DeleteFromSystem {

    fun delete(myAccount: Account){

        var objectPath:String = myAccount.userName + ".ser"

        var listPath:String = if (!myAccount.Approved){
            "registrationList.txt"
        }else{
            myAccount.userType + "List.txt"
        }
        //update list file
        var myArray = AccessListFile.readFromFile(listPath)
        myArray.remove(myAccount.userName)
        AccessListFile.writeToFile(listPath,myArray)

        //delete object file
        val file = File(objectPath)
        val result = file.delete()
        if (result){
            println("File deleted")
        }else{
            println("File Deletion Unsuccessful")
        }
    }
}
