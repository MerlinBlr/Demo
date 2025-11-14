package com.fortech.demo.services;
import com.fortech.demo.dto.ProductResponse;
import com.fortech.demo.mapper.ProductMapper;
import com.fortech.demo.model.Product;
import com.fortech.demo.model.Retailer;
import com.fortech.demo.repository.ProductRepository;
import com.fortech.demo.util.RetailerName;
import lombok.RequiredArgsConstructor;
import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import static com.fortech.demo.util.Constants.*;
import static org.jeasy.random.FieldPredicates.*;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper mapper;
    private final RetailerService retailerService;
    public List<ProductResponse> searchProducts(String text) {
        List<Product> foundProducts = productRepository.findByNameContainsIgnoreCaseOrDescriptionContainsIgnoreCase(text, text);
        return convertToResponseList(foundProducts);
    }
    public List<ProductResponse> createProductsFromAPI() {
        List<Product> createdProducts = createRandomProducts(API_PRODUCT_CREATED_COUNT);
        return convertToResponseList(createdProducts);
    }
    @Transactional
    public void createProductsOnSchedule() {
        createRandomProducts(SCHEDULED_PRODUCT_CREATED_COUNT);
    }
    @Transactional
    public void increaseStockLevel(RetailerName retailerName) {
        productRepository.updateProductByRetailerName(retailerName.getRetailerName(), retailerName.getStockLevel());
    }
    private List<ProductResponse> convertToResponseList(List<Product> products) {
        return products.stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }
    private List<Product> createRandomProducts(int productsCount) {
        List<Retailer> retailers = retailerService.getRetailers();
        Set<Product> products = populateProductsWithRetailers(retailers, productsCount);
        return (List<Product>) productRepository.saveAll(products);
    }
    private Set<Product> populateProductsWithRetailers(List<Retailer> retailers, int productsCount) {
        Set<Product> products = generateRandomData(productsCount);
        for (Product product : products) {
            int retailersCount = getRandomNumber();
            for (int i = 0; i <= retailersCount; i++) {
                product.addRetailer(retailers.get(i));
                retailers.get(i).addProduct(product);
            }
        }
        return products;
    }
    private Set<Product> generateRandomData(int productsCount) {
        EasyRandomParameters parameters = new EasyRandomParameters()
                .randomize(Long.class, () -> DEFAULT_STOCK_LEVEL_VALUE)
                .collectionSizeRange(1, 2)
                .excludeField(named(ID_FIELD_NAME))
                .excludeField(named(RETAILERS_FIELD_NAME).and(ofType(Set.class)).and(inClass(Product.class)));
        EasyRandom generator = new EasyRandom(parameters);
        return generator.objects(Product.class, productsCount)
                .collect(Collectors.toSet());
    }
    private int getRandomNumber() {
        return ThreadLocalRandom.current().nextInt(RANDOM_BOUND);
    }
}