package id.gits.springcodelabs1;

import id.gits.springcodelabs1.Invokers.HttpInvoke;
import id.gits.springcodelabs1.ProductModule.Commands.*;
import id.gits.springcodelabs1.ProductModule.Controllers.ProductController;
import id.gits.springcodelabs1.ProductModule.Models.Product;
import id.gits.springcodelabs1.ProductModule.Receivers.ProductReceiver;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;

import java.util.Arrays;
import java.util.List;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ProductController.class)
public class ProductControllerTest {

    Logger logger = LoggerFactory.getLogger(ProductControllerTest.class);

    @Autowired
    private MockMvc mvc;

    @MockBean
    private HttpInvoke httpInvoke;

    @MockBean
    private GetAllProductsRequest getAllProductsRequest;

    @MockBean
    private CreateProductRequest createProductRequest;

    @MockBean
    private FindProductRequest findProductRequest;

    @MockBean
    private DeleteProductRequest deleteProductRequest;

    @MockBean
    private UpdateProductRequest updateProductRequest;

    @Test
    public void givenProduct_whenGetProduct_thenReturnJsonArray() throws Exception{
//        Product product = new Product((long) 9,"Pocari",4000,100);
//
//        List<Product> allProducts = Arrays.asList(product);
//
//        given(getAllProductsRequest.execute()).willReturn(allProducts);
//        MvcResult apiTest =  mvc.perform(get("/products")
//                            .contentType(MediaType.APPLICATION_JSON))
//                            .andExpect(status().isOk()).andReturn();
//
//        logger.error(apiTest.getResponse().getContentAsString());

    }
}
