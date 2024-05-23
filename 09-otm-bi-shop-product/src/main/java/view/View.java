package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import controller.Controller;
import hibernateUtility.HibernateUtility;
import model.Product;
import model.Shop;

public class View {
	// why static because non-static object loads during object creation
	// thats why we use static Scanner to
	static Scanner myInput = new Scanner(System.in);
	static Controller controller = new Controller();
	static Shop shop = new Shop();
	// static Product product = new Product();

//	private List<Product> products = new ArrayList<Product>();

//	static {
//		System.out.println("-----Welcome to Shop-----");
//		System.out.print("Enter id : ");
//		shop.setShopId(myInput.nextInt());
//		myInput.nextLine();
//		System.out.print("Enter Shop Name : ");
//		shop.setShopName(myInput.nextLine());
//		System.out.print("Enter Owner Name : ");
//		shop.setOwnerName(myInput.nextLine());
//		System.out.print("Enter Shop Address : ");
//		shop.setShopAddress(myInput.nextLine());
//	}

	public static void main(String[] args) {
		do {
			System.out.println("Select Operation to Perform");
			System.out
					.println("1. Add Product's\n2. View Product's \n3. Update Product \n4. Remove Product's\n0. Exit");
			System.out.print("Enter Digit Respective to Desired Option : ");
			byte userChoise = myInput.nextByte();
			switch (userChoise) {
			case 1:// add prodducts
				Product product = new Product();
				System.out.print("Enter Product Id :");
				product.setProductId(myInput.nextInt());
				myInput.nextLine();
				System.out.print("Enter Product Name :");
				product.setProductName(myInput.nextLine());
				System.out.print("Enter Product Price :");
				product.setProductPrice(myInput.nextDouble());
				myInput.nextLine();

				List<Product> product1 = new ArrayList<>();
				product1.add(product);
				product.setShop(shop);
//
//				Shop shop = new Shop();
//				shop.setProduct(product1);
//				System.out.println("-----Welcome to Shop-----");
//				System.out.print("Enter id : ");
//				shop.setShopId(myInput.nextInt());
//				myInput.nextLine();
//				System.out.print("Enter Shop Name : ");
//				shop.setShopName(myInput.nextLine());
//				System.out.print("Enter Owner Name : ");
//				shop.setOwnerName(myInput.nextLine());
//				System.out.print("Enter Shop Address : ");
//				shop.setShopAddress(myInput.nextLine());
				controller.addProduct(product);
				break;
			case 2: // fetch products
				Product proo = new Product();
				Product product2 = HibernateUtility.entityManager.find(Product.class, 655);
				System.out.println("Product ID : " + product2.getProductId());
				System.out.println("Product Name : " + product2.getProductName());
				System.out.println("Product Price : " + product2.getProductPrice());
				System.out.println("Product shop : " + product2.getShop());
				break;
			case 3: // update
				System.out.println("Enter the id to update:");
				Product updateProduct = HibernateUtility.entityManager.find(Product.class, myInput.nextInt());
				myInput.nextLine();
				do {
					System.out.println("Select operation to perform : ");
					System.out.println("1.Update product name\n2.product price");
					System.out.println("Select desired option");
					byte userChoice = myInput.nextByte();
					myInput.nextLine();
					Product prod = updateProduct;
					switch (userChoice) {
					case 1:// update name

						System.out.println("Enter new product name : ");
						prod.setProductName(myInput.nextLine());
						controller.updateProduct(prod);
						break;
					case 2:// update price
						System.out.println("Enter new product price : ");
						prod.setProductPrice(myInput.nextDouble());
						break;
					default:
						System.out.println("Invalid input!!");
						break;
					}
				} while (userChoise != 0);
				break;
			case 4: // delete product
				System.out.println("Enter the id to Delete:");
				Product deleteProduct = HibernateUtility.entityManager.find(Product.class, myInput.nextInt());
				myInput.nextLine();
				controller.deleteProduct(deleteProduct);
				System.out.println("Product removed successfully!!");
				break;
			case 0:
				System.exit(0);
				break;
			default:
				System.out.println("Invalid ");
				break;
			}
		} while (true);
	}

}
