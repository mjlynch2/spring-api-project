# spring-api-project

  A simple project to learn how to build a REST API with Spring Boot. It will read an XML URL (in this case, [a list of restaurants in Baltimore City](https://catalog.data.gov/dataset/restaurants-15baa/resource/70d38c85-513d-4b86-8441-ca200346111d "data.gov")). 
  
  **Paths**
  - `/restaurant/all` will display the entire XML as a string (not very helpful)
  - `/restaurant/{tagName}` will display a list of all values for a given tag name. For example, 
  `/restaurant/name` will display the names of all restaurants in the dataset.

**Valid Tag Names**
- `name` - restaurant name
- `zipcode` - restaurant zip code
- `neighborhood` - restaurant neighborhood name
- `councildistrict` - restaurant council district
- `policedistrict` - restaurant police district
- `location_1` - restaurant street address
