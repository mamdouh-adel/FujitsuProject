package ua.at.mamdouh.ws;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.file.Paths;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.hibernate.Query;
import org.hibernate.Session;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import ua.at.mamdouh.model.Product;
import ua.at.mamdouh.model.Product_Details;
import ua.at.mamdouh.util.HibernateUtil;

@Path("/")
public class Ws_Serv {

	// ------------- product list ----------------------

	@POST
	@Path("/product_service")
	@Produces(MediaType.APPLICATION_JSON)
	public Response productRest(InputStream incomingData) {

		List<Product> productList = getAllProducts();

		JSONArray array = new JSONArray();

		try {

			for (Product product : productList) {

				JSONObject item = new JSONObject();

				item.put("prod_code", product.getProd_code());
				item.put("prod_comp", product.getProd_comp());
				item.put("prod_type", product.getProd_type());
				item.put("prod_model", product.getProd_model());

				array.put(item);
			}

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return Response.ok().header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS")
				.header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With")
				.entity(array.toString()).build();
	}

	// ------------- product details ---------------------

	@POST
	@Path("/product/{prodCode}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response productDetailsRest(@PathParam("prodCode") String prodCode) {

		List<Product_Details> productDetailsList = getProductDetails(prodCode);

		JSONArray array = new JSONArray();

		try {

			for (Product_Details productDetails : productDetailsList) {

				JSONObject item = new JSONObject();

				// item.put("id", productDetails.getId());
				item.put("prod_code", productDetails.getProd_code());
				item.put("prod_model", productDetails.getProd_model());
				item.put("prod_size", productDetails.getProd_size());
				item.put("prod_color", productDetails.getProd_color());
				item.put("prod_degree", productDetails.getProd_degree());

				array.put(item);
			}

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return Response.ok().header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS")
				.header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With")
				.entity(array.toString()).build();
	}

	// ---------------- verify -----------------------------

	@GET
	@Path("/verify")
	@Produces(MediaType.TEXT_PLAIN)
	public Response verifyRESTService(InputStream incomingData) {
		String result = "Product Services Successfully started..";

		// return HTTP response 200 in case of success
		return Response.status(200).entity(result).build();
	}

	// --------------- get Methods that produce HTML code as output
	// ------------------------
	
	//--------------- get Products Page --------------------------------------------------
	
	@GET
	@Path("/products")
	@Produces(MediaType.TEXT_HTML)
	public String createProductsWebPage() {

		String html_output = "NOT LOADED!!!" ;
		
		try {
			
			html_output = getHtmlContent("products.html");
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return html_output;
	}
	
	//--------------- get Product Details By prodCode -----------------------------------------
	
	@GET
	@Path("/products/{prodCode}")
	@Produces(MediaType.TEXT_HTML)
	public String createProduct_DetailsWebPageByProdCode(@PathParam("prodCode") String prodCode) {

		String html_output = "NOT LOADED!!!" ;
		
		try {
			
			html_output = getHtmlContent("productByProdCode.html");
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		html_output = html_output.replaceAll("#rep2#", prodCode);
		
		return html_output;
	}

	// ----- DB Section -------------------------------------

	private List<Product> getAllProducts() {

		Session session = HibernateUtil.getSessionFactory().openSession();

		String hql = "from Product";
		Query query = session.createQuery(hql);
		List<Product> productList = query.list();

		return productList;
	}

	private List<Product_Details> getProductDetails(String prodCode) {

		Session session = HibernateUtil.getSessionFactory().openSession();

		String hql = "from Product_Details  where prod_code = '" + prodCode + "' ";
		Query query = session.createQuery(hql);
		List<Product_Details> productDetailsList = query.list();

		return productDetailsList;
	}

	// ----- END of DB Section ----------------------------------
	

	// ----------- get path -------------------

	public String getHtmlContent(String webPage) throws UnsupportedEncodingException {
		
		String path = this.getClass().getClassLoader().getResource("").getPath();
		
		String fullPath = URLDecoder.decode(path, "UTF-8");
		
		String pathArr[] = fullPath.split("/WEB-INF/classes/");
		
		fullPath = pathArr[0];
		
		String reponsePath = "";
		
		// to read a file from webcontent
		
		reponsePath = new File(fullPath).getPath() + File.separatorChar + "pages" +File.separatorChar + webPage;
		
		return fileContent(reponsePath);
	}
	
	//----  read file method --------------
	
	//---------------  try with resources --------------------------------
	
	/*private String fileContent(String filePath) {
		
		StringBuilder sb = new StringBuilder();
		
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

			String sCurrentLine;

			while ((sCurrentLine = br.readLine()) != null) {
		//		System.out.println(sCurrentLine);
				sb.append(sCurrentLine).append("\n");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return sb.toString();
	}*/


	//--------------- if  try with resources not supported --------------------------------
	
	private String fileContent(String filePath) {
		
		StringBuilder sb = new StringBuilder();
		
		BufferedReader br = null ;
		
		try {
			
			 br = new BufferedReader(new FileReader(filePath));

			String sCurrentLine;

			while ((sCurrentLine = br.readLine()) != null) {
		//		System.out.println(sCurrentLine);
				sb.append(sCurrentLine).append("\n");
			}

		} catch (IOException e) {
			e.printStackTrace();
	
		}finally {
			
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return sb.toString();
	}

}
