package bankingSystem

import java.io.File

class AddDeleteFromSystem {

    companion object{

        fun add(myAccount: Account){

            var objectPath:String = myAccount.userName + ".ser"

            var listPath:String = if (!myAccount.Approved){
                "registrationList.txt"
            }else{
                myAccount.userType + "List.txt"
            }
            //update list file
            var myArray = AccessListFile.readFromFile(listPath)
            myArray.add(myAccount.userName)
            AccessListFile.writeToFile(listPath,myArray)
            //write to file
            AccessObjectFile.writeToFile(objectPath,myAccount)
        }

        fun approve(myAccount: Account){

            myAccount.Approved = true
            //update list file
            var myArray = AccessListFile.readFromFile("registrationList.txt")
            myArray.remove(myAccount.userName)
            AccessListFile.writeToFile("registrationList.txt",myArray)
            add(myAccount)
        }

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
}
