document
  .getElementById("logistics-form")
  .addEventListener("submit", function (event) {
    event.preventDefault();

    // Get form values
    const rootName = document.getElementById("rootName").value;
    const location = document.getElementById("location").value;
    const truckNumber = document.getElementById("truckNumber").value;
    const goodsType = document.getElementById("goodsType").value;

    // Log values (or further process them)
    console.log(`Root Name: ${rootName}`);
    console.log(`Location: ${location}`);
    console.log(`Truck Number: ${truckNumber}`);
    console.log(`Type of Goods: ${goodsType}`);

    // Display confirmation message
    alert(
      `Form submitted successfully:\nRoot Name: ${rootName}\nLocation: ${location}\nTruck Number: ${truckNumber}\nType of Goods: ${goodsType}`
    );
  });
