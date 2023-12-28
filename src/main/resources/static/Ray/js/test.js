// script.js

// Function to make an AJAX request
function fetchDataFromBackend() {
    console.log("Sdcsdc");
    // Make a GET request to the backend endpoint
    fetch('/fetchData')
        .then(response => {
            // Check if the response is successful
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            // Parse the JSON response
            return response.text();
        })
        .then(data => {
            // Display the data in the HTML element
            document.getElementById('dataDisplay').innerText = data;
        })
        .catch(error => {
            // Handle any errors that occurred during the fetch
            console.error('There was a problem with the fetch operation:', error);
        });
}

// Call the function to fetch data when the page loads
document.addEventListener('DOMContentLoaded', fetchDataFromBackend);
