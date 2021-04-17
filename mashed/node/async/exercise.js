// getCustomer(1, (customer) => {
//   console.log('Customer: ', customer);
//   if (customer.isGold) {
//     getTopMovies((movies) => {
//       console.log('Top movies: ', movies);
//       sendEmail(customer.email, movies, () => {
//         console.log('Email sent...')
//       });
//     });
//   }
// });

async function exercise(){
  let customer = await getCustomer(1);
  console.log('Customer: ', customer);
  if (customer.isGold) {
    let movies = await getTopMovies();
    console.log('Top movies: ', movies);
    await sendEmail(customer.email, movies);
    console.log('Email sent...');
  }
}
exercise();


//ut promises

// const customer = getCustomer(1);
// const movies = customer
//   .then((customer)=>{
//     console.log('Customer: ', customer);
//     if (customer.isGold) {
//       return getTopMovies();
//     }
//   });
//   movies
//   .then((movies)=>{
//     console.log('Top movies: ', movies);
//     return sendEmail(customer.email, movies);
//   })
//   .then(()=>{console.log('Email sent...')});




function getCustomer(id) {
  return new Promise((resolve,reject)=>{
    setTimeout(() => {
      resolve({ 
        id: 1, 
        name: 'Mosh Hamedani', 
        isGold: true, 
        email: 'email' 
      });
    }, 2000);
  });
}

function getTopMovies() {
  return new Promise((resolve, reject)=>{
    setTimeout(() => {
    resolve(['movie1', 'movie2']);
    }, 2000);
  });
}

function sendEmail(email, movies) {
  return new Promise((resolve, reject)=>{
    setTimeout(() => {
      resolve();
    }, 2000);
  })
}