const getProducts = ()  =>{
    return fetch('/api/products')
        .then( response => response.json())
        .catch(error => console.log(error))
}

(() => {
    console.log("it works");
    getProducts()
        //.then(products => //create html structure with products)
    .then(products => console.log(products)) //create html structure with products)

})();