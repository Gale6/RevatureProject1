package bankingSystem

class UI {
    companion object{

        fun mainMenuUI(){

            println("           Welcome to the Bank")

            //registration or login
            var registOrLogin = ""
            do{
                println("Please select what you want to do: ")
                println("1 for registration")
                println("2 for login")
                registOrLogin = readLine().toString()
                if((registOrLogin != "1") and (registOrLogin != "2")){
                    println("           Invalid input, you can only choose 1 or 2")
                }
            }while((registOrLogin != "1") and (registOrLogin != "2"))

            when(registOrLogin){
                "1" -> registrationUI()
                "2" -> loginUI()
            }
        }

        fun registrationUI(){

            val registrationList = AccessListFile.readFromFile("registrationList.txt")
            val accountList = AccessListFile.readFromFile("accountList.txt")
            println("           Welcome to registration")

            //setting username
            var username = ""
            do{
                println("Please enter your username")
                username = readLine().toString()
                if(registrationList.contains(username) or accountList.contains(username)){
                    println("           Username already exist, please enter a new username")
                }
            }while (registrationList.contains(username) or accountList.contains(username))

            //setting password
            println("Please enter your password")
            var password = readLine().toString()

            //setting account type
            var userType = ""
            do{
                println("Please select your account type")
                println("1 for customer\n2 for employee\n3 for admin")
                userType = readLine().toString()
                if((userType != "1") and (userType != "2") and  (userType != "3")){
                    println("           Invalid input, you can only choose 1, 2 or 3")
                }
            }while ((userType != "1") and (userType != "2") and  (userType != "3"))
            userType = when(userType){
                "1" -> "customer"
                "2" -> "employee"
                else -> {"admin"}
            }

            //setting account type
            var accountType = ""
            if (userType == "customer"){
                do{
                    println("Please select account type:")
                    println("1 for regular")
                    println("2 for joint")
                    accountType = readLine().toString()
                    if((accountType != "1") and (accountType != "2")){
                        println("           Invalid input, you can only choose 1 or 2")
                    }
                }while ((accountType != "1") and (accountType != "2"))
            }
            accountType = when(accountType){
                "2" -> "joint"
                else ->{"regular"}
            }

            //create an account object
            val myAccount = Account(username,password,userType,accountType)

            //add to system
            AddDeleteFromSystem.add(myAccount)
            println("           Congratulations! You have completed registration. Please wait to approval.")
            println("")
        }

        fun loginUI(){
            //todo
        }

        fun customerUI(){
            //todo
        }

        fun employeeUI(){
            //todo
        }

        fun adminUI(){
            //todo
        }


    }
}