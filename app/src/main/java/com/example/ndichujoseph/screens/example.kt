import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.ndichujoseph.R
import com.example.ndichujoseph.ui.theme.NDICHUJOSEPHTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CatalogScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Catalog") },
                navigationIcon = {
                    IconButton(onClick = { }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                },
                actions = {
                    IconButton(onClick = {}) {
                        Icon(Icons.Filled.Person, contentDescription = "Profile")
                    }
                    IconButton(onClick = {}) {
                        Icon(Icons.Filled.ShoppingCart, contentDescription = "Cart")
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 16.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
                    .background(Color.Black)
                    .padding(bottom = 16.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.banner),
                    contentDescription = "Sportswear Banner",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
                Text(
                    text = "Sportswear",
                    color = Color.LightGray,
                    fontSize = 34.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .align(Alignment.Center)
                        .padding(16.dp)
                        .background(Color.Transparent)
                        .padding(8.dp)
                )
            }


            CatalogItem(
                imageResource = R.drawable.cycling,
                name = "Cycling Jersey",
                category = "Cycling",
                price = "$45.99"
            )
            Divider()

            CatalogItem(
                imageResource = R.drawable.run,
                name = "Performance Running T-Shirt",
                category = "Sportswear",
                price = "$29.99"
            )
            Divider()


            CatalogItem(
                imageResource = R.drawable.basket,
                name = "Men's Basketball Shorts",
                category = "Sportswear",
                price = "$34.99"
            )
            Divider()
            CatalogItem(
                imageResource = R.drawable.women,
                name = "Women's Basketball Shorts",
                category = "Sportswear",
                price = "$35.99"
            )
            Divider()
            CatalogItem(
                imageResource = R.drawable.bmx,
                name = "BMX bicycle",
                category = "Sports",
                price = "$78.99"
            )
            Divider()
            CatalogItem(
                imageResource = R.drawable.ball,
                name = "Basketball Balls",
                category = "Sports",
                price = "$58.99"
            )
        }
    }
}

@Composable
fun CatalogItem(
    imageResource: Int,
    name: String,
    category: String,
    price: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = imageResource),
            contentDescription = name,
            modifier = Modifier
                .size(80.dp)
                .background(Color.LightGray),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(text = name, fontWeight = FontWeight.Bold, fontSize = 16.sp)
            Text(text = category, color = Color.Gray, fontSize = 14.sp)
        }
        Text(text = price, fontWeight = FontWeight.Bold, fontSize = 16.sp)
    }
}

@Composable
fun Divider() {
    Spacer(
        modifier = Modifier
            .fillMaxWidth()
            .height(1.dp)
            .background(Color.LightGray)
    )
}

@Preview(showBackground = true)
@Composable
fun CatalogScreenPreview() {
    NDICHUJOSEPHTheme {
        val mockNavController=rememberNavController()
        CatalogScreen(navController=mockNavController)
    }
}