package Service;


import Constants.AccessLevel;
import Constants.Data;
import Utils.Writer;
import model.Account;
import model.Result;
import model.Root;

public class AccountService {

   static Writer writer = new Writer(Root.class, Account.class);

    public static Result create(String username, String password, AccessLevel accessLevel) {
        System.out.println("[AccountService]: Creating account with:"+username+" password:"+password+" AccessLevel:"+accessLevel.toString());
        Account account = new Account(username,password,accessLevel);
        Root<Account> accounts = (Root<Account>) writer.read(Data.account);
        for (Account acc: accounts.getRoot()){
            if (!acc.equals(account)) {
                accounts.add(account);
                writer.write(Data.account,accounts);
                return new Result("SUCCESS",null);
            }
        }
        return new Result("FAIL",null);
    }

    public static Result get(String username) {
        System.out.println("[AccountService]: getting user, username:"+username);
        if(writer.read(Data.account) == null){
            return new Result("FAIL",null);
        }else{
            Root<Account> accounts = (Root<Account>) writer.read(Data.account);
            for (Account acc : accounts.getRoot()) {
                if (acc.getUsername().equals(username)) {
                    return new Result("SUCCESS", acc);
                }
            }
        }
        return new Result("FAIL",null);
    }

    public static Result update(Account account) {
        System.out.println("[AccountService]: updating Account, username ="+account.getUsername());
        Root<Account> accounts = (Root<Account>) writer.read(Data.account);
        for(Account account1: accounts.getRoot()){
            if(account1.equals(account)){
                accounts.remove(account1);
                accounts.add(account);
                return new Result("SUCCESS",null);
            }
        }
        return new Result("FAIL",null);
    }

    public static Result delete(String username) {
        System.out.println("[AccountService]: Deleting user, username ="+username);
        Root<Account> accounts = (Root<Account>) writer.read(Data.account);
        for (Account account: accounts.getRoot()){
            if (account.getUsername().equals(username)){
                accounts.remove(account);
                return new Result("SUCCESS",null);
            }
        }
        return new Result("FAIL",null);
    }
}
