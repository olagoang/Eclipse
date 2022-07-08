package com.capgemini.ccsw.tutorial.prestamo;
/*
 * import static org.junit.Assert.assertEquals; import static
 * org.junit.Assert.assertNotNull;
 * 
 * import org.junit.Test; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.boot.test.context.SpringBootTest; import
 * org.springframework.boot.test.web.client.TestRestTemplate; import
 * org.springframework.boot.web.server.LocalServerPort; import
 * org.springframework.core.ParameterizedTypeReference; import
 * org.springframework.data.domain.Page; import
 * org.springframework.data.domain.PageRequest; import
 * org.springframework.http.HttpEntity; import
 * org.springframework.http.HttpMethod; import
 * org.springframework.http.ResponseEntity; import
 * org.springframework.test.annotation.DirtiesContext;
 * 
 * import com.capgemini.ccsw.tutorial.author.model.AuthorDto; import
 * com.capgemini.ccsw.tutorial.category.model.CategoryDto; import
 * com.capgemini.ccsw.tutorial.client.model.ClientDto; import
 * com.capgemini.ccsw.tutorial.game.model.GameDto; import
 * com.capgemini.ccsw.tutorial.prestamo.model.PrestamoDto; import
 * com.capgemini.ccsw.tutorial.prestamo.model.PrestamoSearchDto;
 * 
 * @SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
 * 
 * @DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
 * public class PrestamoIT {
 * 
 * public static final String LOCALHOST = "http://localhost:"; public static
 * final String SERVICE_PATH = "/prestamos/";
 * 
 * public static final Long DELETE_PRESTAMO_ID = 4L; public static final Long
 * MODIFY_PRESTAMO_ID = 3L; public static final Long NEW_GAME_ID = 2L; public
 * static final Long NEW_CLIENT_ID = 3L;
 * 
 * private static final int TOTAL_PRESTAMOS = 4; private static final int
 * PAGE_SIZE = 5;
 * 
 * @LocalServerPort private int port;
 * 
 * @Autowired private TestRestTemplate restTemplate;
 * 
 * ParameterizedTypeReference<Page<PrestamoDto>> responseTypePage = new
 * ParameterizedTypeReference<Page<PrestamoDto>>() { };
 * 
 * @Test public void findFirstPageWithFiveSizeShouldReturnFirstFiveResults() {
 * 
 * PrestamoSearchDto searchDto = new PrestamoSearchDto();
 * searchDto.setPageable(PageRequest.of(0, PAGE_SIZE));
 * 
 * ResponseEntity<Page<PrestamoDto>> response = restTemplate.exchange(LOCALHOST
 * + port + SERVICE_PATH, HttpMethod.POST, new HttpEntity<>(searchDto),
 * responseTypePage);
 * 
 * assertNotNull(response); assertEquals(TOTAL_PRESTAMOS,
 * response.getBody().getTotalElements()); assertEquals(PAGE_SIZE,
 * response.getBody().getContent().size());
 * 
 * }
 * 
 * @Test public void findSecondPageWithFiveSizeShouldReturnLastResult() {
 * 
 * int elementsCount = TOTAL_PRESTAMOS - PAGE_SIZE;
 * 
 * PrestamoSearchDto searchDto = new PrestamoSearchDto();
 * searchDto.setPageable(PageRequest.of(1, PAGE_SIZE));
 * 
 * ResponseEntity<Page<PrestamoDto>> response = restTemplate.exchange(LOCALHOST
 * + port + SERVICE_PATH, HttpMethod.POST, new HttpEntity<>(searchDto),
 * responseTypePage);
 * 
 * assertNotNull(response); assertEquals(TOTAL_PRESTAMOS,
 * response.getBody().getTotalElements()); assertEquals(elementsCount,
 * response.getBody().getContent().size()); }
 * 
 * @Test public void saveWithoutIdShouldCreateNewPrestamo() {
 * 
 * long newPrestamoId = TOTAL_PRESTAMOS + 1; long newPrestamoSize =
 * TOTAL_PRESTAMOS + 1;
 * 
 * PrestamoDto dto = new PrestamoDto();
 * 
 * AuthorDto authordto = new AuthorDto(); CategoryDto catdto = new
 * CategoryDto(); GameDto gamedto = new GameDto(); ClientDto clientdto = new
 * ClientDto();
 * 
 * gamedto.setAge("2"); gamedto.setAuthor(authordto);
 * gamedto.setCategory(catdto); gamedto.setTitle("Fornite 2");
 * gamedto.setId(5L);
 * 
 * dto.setGame(gamedto); dto.setClient(clientdto);
 * 
 * restTemplate.exchange(LOCALHOST + port + SERVICE_PATH, HttpMethod.PUT, new
 * HttpEntity<>(dto), Void.class);
 * 
 * PrestamoSearchDto searchDto = new PrestamoSearchDto();
 * searchDto.setPageable(PageRequest.of(0, (int) newPrestamoSize));
 * 
 * ResponseEntity<Page<PrestamoDto>> response = restTemplate.exchange(LOCALHOST
 * + port + SERVICE_PATH, HttpMethod.POST, new HttpEntity<>(searchDto),
 * responseTypePage);
 * 
 * assertNotNull(response); assertEquals(newPrestamoSize,
 * response.getBody().getTotalElements());
 * 
 * PrestamoDto prestamo = response.getBody().getContent().stream() .filter(item
 * -> item.getId().equals(newPrestamoId)).findFirst().orElse(null);
 * assertNotNull(prestamo); assertEquals(gamedto, prestamo.getGameDto());
 * 
 * }
 * 
 * }
 */
