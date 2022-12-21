/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Context.Utils;
import Entity.Account;
import Entity.Bill;
import Entity.Cart;
import Entity.Category;
import Entity.Product;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.persistence.*;

public class DAO {
        static EntityManager  em = Utils.getEntityManager();
        static EntityTransaction trans = em.getTransaction();
        
        public static List<Product> getAllProduct(){
            String jpql="select o from Product o";
            TypedQuery<Product> query = em.createQuery(jpql,Product.class);
            List<Product> list = query.getResultList();            
            return list;
        } 
        
        public static List<Product> getProductByPage(int pageid){
            int maxPageProduct = 0;
            List<Product> listNeed=new ArrayList<>();
            String jpql="select o from Product o";
            TypedQuery<Product> query = em.createQuery(jpql,Product.class);
            List<Product> list = query.getResultList(); 
            for(int i=1;i < pageid;i++){
                for(int j=0;j<3;j++){
                    list.remove(0);
                }
            }
            for(Product p :list){
                listNeed.add(p);
                maxPageProduct++;
                if(maxPageProduct==9) break;
            }
            return listNeed;
        } 
        
        public static List<Category> getAllCategory(){
            String jpql="select o from Category o";
            TypedQuery<Category> query = em.createQuery(jpql,Category.class);
            List<Category> listc = query.getResultList();            
            return listc;
        }
        
        public static List<Account> getAllAccount(){
            String jpql="select o from Account o";
            TypedQuery<Account> query = em.createQuery(jpql,Account.class);
            List<Account> list = query.getResultList();            
            return list;
        }
        
        public static List<Bill> getAllBill(){
            String jpql="select o from Bill o";
            TypedQuery<Bill> query = em.createQuery(jpql,Bill.class);
            List<Bill> list = query.getResultList();            
            return list;
        }
        
        public static Product getLast(){
            String jpql="select o from Product o order by o.id desc";
            TypedQuery<Product> query = em.createQuery(jpql,Product.class);
            query.setMaxResults(1);
            Product product = query.getSingleResult();
            return product;
        }
        
        public static List<Product> getFetured(){
            String jpql="select o from Product o order by o.id desc";
            TypedQuery<Product> query = em.createQuery(jpql,Product.class);
            query.setMaxResults(8);
            List<Product> list = query.getResultList();            
            return list;
        }
        
        public static List<Product> getProductsByID(String cid){
            String jpql="select o from Product o where o.cateid = "+cid;
            TypedQuery<Product> query = em.createQuery(jpql,Product.class);
            List<Product> product = query.getResultList();
            return product;
        }
        
        public static List<Bill> getBillsByID(String id){
            String jpql="select o from Bill o where o.accid = "+id;
            TypedQuery<Bill> query = em.createQuery(jpql,Bill.class);
            List<Bill> Blist = query.getResultList();
            return Blist;
        }
        
        public static Product getProductByID(String id){
            String jpql="select o from Product o where o.id = "+id;
            TypedQuery<Product> query = em.createQuery(jpql,Product.class);
            Product product = query.getSingleResult();
            return product;
        }
        
        public static List<Cart> getProductByDetail(String detail){
            char[] cdetail = detail.toCharArray();
            List<Cart> Plist = new ArrayList<>();
            for(int i=0;i < detail.length();i++){
                if(cdetail[i]!='/'){
                    Cart cart = new Cart();
                    Product product = new Product();
                        product = DAO.getProductByID(Character.toString(cdetail[i]));
                        i+=2;
                        cart.setPid(product.getId());
                        cart.setAmount(Character.getNumericValue(cdetail[i]));
                        cart.setName(product.getName());
                        cart.setPrice(product.getPrice());
                    Plist.add(cart);
                }
            }
            return Plist;
        }
        
        public static Bill getBillByID(String id){
            String jpql="select o from Bill o where o.id = "+id;
            TypedQuery<Bill> query = em.createQuery(jpql,Bill.class);
            Bill bill = query.getSingleResult();
            return bill;
        }
        
        public static List<Product> getYouMayAlsoLike(){
            String jpql="select o from Product o order by o.id desc";
            TypedQuery<Product> query = em.createQuery(jpql,Product.class);
            query.setMaxResults(5);
            List<Product> alsolike = query.getResultList();
            return alsolike;
        }
        
        public static List<Product> getBySearch(String text){
            String jpql="select o from Product o where o.name like "+"'%"+text+"%'";
            TypedQuery<Product> query = em.createQuery(jpql,Product.class);
            List<Product> search = query.getResultList();
            return search;
        }
        
        public static Account getLogin(String email, String pass){
            String jpql="select o from Account o where o.email = '"+ email +"' and o.password = '"+ pass+"'";
            try{
                TypedQuery<Account> query = em.createQuery(jpql,Account.class);
                Account login = query.getSingleResult();
                return login;
            }catch(Exception e){
            }
            return null;
        }
        
        public static Account getLoginByGoogle(String email){
            String jpql="select o from Account o where o.email = '"+ email+"'";
            try{
                TypedQuery<Account> query = em.createQuery(jpql,Account.class);
                Account login = query.getSingleResult();
                return login;
            }catch(Exception e){
            }
            return null;
        }
        
        public static Account checkUsetExist(String email){
            String jpql="select o from Account o where o.email = '"+ email+"'";
            try{
                TypedQuery<Account> query = em.createQuery(jpql,Account.class);
                Account check = query.getSingleResult();
                return check;
            }catch(Exception e){
            }
            return null;
        }
        
        public static int getNewID(){
            try{
                String jpql="select o from Account o order by o.acid desc";
                TypedQuery<Account> query = em.createQuery(jpql,Account.class);
                query.setMaxResults(1);
                Account accountid = query.getSingleResult();   
                return accountid.getAcid()+1;
            }catch(Exception e){
                return 1;
            }
        }
        
        public static int getNewProductID(){
            try{
                String jpql="select o from Product o order by o.id desc";
                TypedQuery<Product> query = em.createQuery(jpql,Product.class);
                query.setMaxResults(1);
                Product proid = query.getSingleResult();   
                return proid.getId()+1;
            }catch(Exception e){
                return 1;
            }
        }
        
        public static int getNewCartID(){
            try{
                String jpql="select o from Cart o order by o.id desc";
                TypedQuery<Cart> query = em.createQuery(jpql,Cart.class);
                query.setMaxResults(1);
                Cart newCart = query.getSingleResult();
                return newCart.getId()+1;
            }catch(Exception e){
                return 1;
            }
        }
        
        public static int getNewBillID(){
            try{
                String jpql="select o from Bill o order by o.id desc";
                TypedQuery<Bill> query = em.createQuery(jpql,Bill.class);
                query.setMaxResults(1);
                Bill bill = query.getSingleResult();   
                return bill.getId()+1;
            }catch(Exception e){
                return 1;
            }
        }
        
        public static void setAccount(String email,String pass){
            Account newAccount = new Account(DAO.getNewID(),email,pass,false,false);
            try{
                trans.begin();
                em.persist(newAccount);
                trans.commit();
            }catch(Exception e){
                trans.rollback();
            }
        }
        
        public static void setAccountByGoogle(String email,String name){
            Account newAccount = new Account(DAO.getNewID(),email,null,false,false);
            newAccount.setName(name);
            try{
                trans.begin();
                em.persist(newAccount);
                trans.commit();
            }catch(Exception e){
                trans.rollback();
            }
        }
        
        public static void UpdateProduct(int id,String name,String image,int price,String title,String Description,int category,int amount){
            Product UpdateProduct = new Product(id,name,image, price, title, Description, category,amount);
            try{
                trans.begin();
                em.merge(UpdateProduct);
                trans.commit();
            }catch(Exception e){
                trans.rollback();
            }
        }
        
        public static void DeleteByID(String delid){
            String jpql="select o from Product o where o.id = '"+ delid+"'";
            TypedQuery<Product> query = em.createQuery(jpql,Product.class);
            Product delproduct = query.getSingleResult(); 
            try{
                trans.begin();
                em.remove(delproduct);
                trans.commit();
            }catch(Exception e){
                trans.rollback();
            }
        }
        
        public static void addProduct(String name,String image,int price,String title,String Description,int category,int amount){
            Product newProduct = new Product(DAO.getNewProductID(),name,image, price, title, Description, category,amount);
            try{
                trans.begin();
                em.persist(newProduct);
                trans.commit();
            }catch(Exception e){
                trans.rollback();
            }
        }
        
        public static String getCateBycateid(int cateid){
           String jpql="select o from Category o where o.catid = '"+ cateid+"'";
           TypedQuery<Category> query = em.createQuery(jpql,Category.class);
           Category cate = query.getSingleResult(); 
           return cate.getCatname();
       }
       
        public static void AddToCart(String pid, int uid){
           Product getProduct = DAO.getProductByID(pid);
           Cart newProduct = new Cart(DAO.getNewCartID(),getProduct.getName(),getProduct.getImage(),1,getProduct.getPrice(),getProduct.getId(),uid,getProduct.getPrice());
            try{
                trans.begin();
                em.persist(newProduct);
                trans.commit();
            }catch(Exception e){
                trans.rollback();
            }
       }
       
        public static void RemoveFromCart(String pid, String cartid){
            String jpql="select o from Cart o where o.pid = '"+ pid+"' and o.cartid = '"+cartid+"'";
            TypedQuery<Cart> query = em.createQuery(jpql,Cart.class);
            Cart delproduct = query.getSingleResult(); 
            try{
                trans.begin();
                em.remove(delproduct);
                trans.commit();
            }catch(Exception e){
                trans.rollback();
            }
        }
       
        public static void RemoveAccount(String id){
            String jpql="select o from Account o where o.acid = '"+ id+"'";
            TypedQuery<Account> query = em.createQuery(jpql,Account.class);
            Account delaccount = query.getSingleResult(); 
            try{
                trans.begin();
                em.remove(delaccount);
                trans.commit();
            }catch(Exception e){
                trans.rollback();
            }
        }
       
        public static void RemoveBill(String id){
            String jpql="select o from Bill o where o.id = '"+ id+"'";
            TypedQuery<Bill> query = em.createQuery(jpql,Bill.class);
            Bill bill = query.getSingleResult(); 
            try{
                trans.begin();
                em.remove(bill);
                trans.commit();
            }catch(Exception e){
                trans.rollback();
            }
        }
           
        public static void ReFundBill(List<Cart> userCart){
            List<Product> Plist = new ArrayList<>();
            for(Cart c : userCart){
                 Product p = getProductByID(c.getPid().toString());
                 p.setCount(p.getCount()+c.getAmount());
                 Plist.add(p);
            }
            for(Product p : Plist){
                try{
                    trans.begin();
                    em.merge(p);
                    trans.commit();
                }catch(Exception e){
                    trans.rollback();
                }
            }
        }
        
        public static List<Cart> getUserCart(String id){
            String jpql="select o from Cart o where o.cartid="+id;
            TypedQuery<Cart> query = em.createQuery(jpql,Cart.class);
            List<Cart> ucart = query.getResultList();
            return ucart;
        }
       
        public static Account getUserAccount(String id){
            String jpql="select o from Account o where o.acid="+id;
            TypedQuery<Account> query = em.createQuery(jpql,Account.class);
            Account acc = query.getSingleResult();
            return acc;
        }
       
        public static boolean CheckCartExist(String uid, String pid){
           try{
                String jpql="select o from Cart o where o.cartid = '"+ uid+"'"+" and o.pid = '"+pid+"'";
                TypedQuery<Cart> query = em.createQuery(jpql,Cart.class);
                Cart ExistProduct = query.getSingleResult();
                if(ExistProduct!=null) return true;
           }catch(Exception e){
               
           }
           return false;
       }
        
        public static void CheckProductsStatus(){
                String jpql="select o from Product o ";
                TypedQuery<Product> query = em.createQuery(jpql,Product.class);
                List<Product> products = query.getResultList();
                for(Product p : products){
                    if(p.getCount()>0){
                        p.setStatus("Còn hàng");
                            try{
                                trans.begin();
                                em.merge(p);
                                trans.commit();
                            }catch(Exception e){
                                trans.rollback();
                            }
                    }
                    else{
                            p.setStatus("Hết hàng");
                            try{
                                trans.begin();
                                em.merge(p);
                                trans.commit();
                            }catch(Exception e){
                                trans.rollback();
                            }
                    }
                }
       }
        
                public static void CheckProductsCount(String cartid){
                    String jpql="select o from Cart o where o.cartid="+cartid;
                    TypedQuery<Cart> query = em.createQuery(jpql,Cart.class);
                    List<Cart> userCart = query.getResultList();
                    List<Product> Plist = new ArrayList<>();
                    for(Cart c : userCart){
                        Product p = getProductByID(c.getPid().toString());
                        p.setCount(p.getCount()-c.getAmount());
                        Plist.add(p);
                    }
                    for(Product p : Plist){
                        try{
                                trans.begin();
                                em.merge(p);
                                trans.commit();
                            }catch(Exception e){
                                trans.rollback();
                            }
                    }
                }
        
        public static void AddExist(String uid, String pid){
                String jpql="select o from Cart o where o.cartid = '"+ uid+"'"+" and o.pid = '"+pid+"'";
                TypedQuery<Cart> query = em.createQuery(jpql,Cart.class);
                Cart ExistProduct = query.getSingleResult();
                ExistProduct.setAmount(ExistProduct.getAmount()+1);
                int total = ExistProduct.getAmount() * ExistProduct.getPrice();
                ExistProduct.setTotal(total);
                try{
                    trans.begin();
                    em.merge(ExistProduct);
                    trans.commit();
                }catch(Exception e){
                    trans.rollback();
            }       
       }
       
        public static void ChangeCartAmount(String pid,String cartid, String newAmount){
                String jpql="select o from Cart o where o.pid = '"+ pid+"'"+" and o.cartid = '"+cartid+"'";
                TypedQuery<Cart> query = em.createQuery(jpql,Cart.class);
                Cart cartProduct = query.getSingleResult();
                cartProduct.setAmount(Integer.parseInt(newAmount));
                int total = cartProduct.getAmount() * cartProduct.getPrice();
                cartProduct.setTotal(total);
                try{
                    trans.begin();
                    em.merge(cartProduct);
                    trans.commit();
                }catch(Exception e){
                    trans.rollback();
            }  
       }
       
        public static void saveProfile(String currAccountid,String name,String email,String address,String password,String sdt){
           String jpql="select o from Account o where o.acid = '"+ currAccountid+"'";
           TypedQuery<Account> query = em.createQuery(jpql,Account.class);
           Account profile = query.getSingleResult();
           profile.setName(name);
           profile.setEmail(email);
           profile.setAddress(address);
           profile.setPassword(password);
           profile.setSdt(sdt);
           try{
                    trans.begin();
                    em.merge(profile);
                    trans.commit();
                }catch(Exception e){
                    trans.rollback();
            }       
       }
       
        public static void AddNewBill(String uid,int total,String name,String sdt,String address){
           List<Cart> cart = DAO.getUserCart(uid);
           String detail="";
           for (Cart o : cart) {
               detail  += o.getPid() + "," + o.getAmount()+"/"; 
               DAO.RemoveFromCart(o.getPid().toString(),uid);
           }
           String datetime = new SimpleDateFormat("yyyy/MM/dd_HH:mm:ss").format(Calendar.getInstance().getTime());
           Bill newBill = new Bill(DAO.getNewBillID(),Integer.parseInt(uid),detail,datetime,total,name,sdt,address);
            try{
                trans.begin();
                em.persist(newBill);
                trans.commit();
            }catch(Exception e){
                trans.rollback();
            }
       }
       
        public static void setAccountAccess(String action,String setAccess,String accid){
                String jpql="select o from Account o where o.acid = '"+ accid+"'";
                TypedQuery<Account> query = em.createQuery(jpql,Account.class);
                Account account = query.getSingleResult();
                if(action.equals("sell")){
                    if(setAccess.equals("true")) account.setIssell(true);
                    if(setAccess.equals("false")) account.setIssell(false);
                }
                if(action.equals("adminaccess")){
                    if(setAccess.equals("true")) account.setIsadmin(true);
                    if(setAccess.equals("false")) account.setIsadmin(false);
                }
                try{
                    trans.begin();
                    em.merge(account);
                    trans.commit();
                }catch(Exception e){
                    trans.rollback();
            }       
       }
       
        public static void setOrderStatus(String id, String status){
            String jpql="select o from Bill o where o.id = '"+ id+"'";
            TypedQuery<Bill> query = em.createQuery(jpql,Bill.class);
            Bill bill = query.getSingleResult();
            bill.setStatus(status);
            try{
                trans.begin();
                em.merge(bill);
                trans.commit();
            }catch(Exception e){
                trans.rollback();
            }       
        }
        
        public static void main(String[] args) {
            List<Cart> cart = DAO.getProductByDetail("1,2/1,3");
            DAO.ReFundBill(cart);
    }
}