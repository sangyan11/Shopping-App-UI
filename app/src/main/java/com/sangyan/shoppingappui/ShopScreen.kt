package com.sangyan.shoppingappui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import androidx.compose.ui.text.withStyle
import com.yourapp.ui.theme.CenturyOldStyle
import com.yourapp.ui.theme.Neuzeit
import com.yourapp.ui.theme.Tangerine

data class Product(
    val id: String,
    val name: String,
    val description: String,
    val price: Double,
    val originalPrice: Double? = null,
    val imageUrl: Int, // Using Int for drawable resource ID
    val isInStock: Boolean = true,
    val isBestSeller: Boolean = false,
    val rating: Double = 0.0,
    val reviewsCount: Int = 0,
    val isFavourite: Boolean = true
)

data class Category(
    val id: String,
    val name: String,
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShopFlowScreen() {
    val categories = listOf(
        Category("1", "Cleaners"),
        Category("2", "Toner"),
        Category("3", "Serums"),
        Category("4", "Moisturisers"),
        Category("5", "Sunscreen"),
        Category("6", "Masks")
    )

    val products = listOf(
        Product(
            id = "p1",
            name = "clencera",
            description = "French clay and algae-powered cleanser\nSkin Tightness • Dry & Dehyrated Skin",
            price = 355.20,
            originalPrice = 444.00,
            imageUrl = R.drawable.product_image,
            isInStock = true,
            isBestSeller = true,
            rating = 4.5,
            isFavourite = true,
            reviewsCount = 249
        ),
        Product(
            id = "p2",
            name = "glow",
            description = "French clay and algae-powered cleanser\nSkin Tightness • Dry & Dehyrated Skin",
            price = 355.20,
            originalPrice = 444.00,
            imageUrl = R.drawable.product_image,
            isInStock = true,
            isFavourite = false,
            isBestSeller = false,
            rating = 4.5,
            reviewsCount = 249
        ),
        Product(
            id = "p3",
            name = "afterglow",
            description = "French clay and algae-powered cleanser\nSkin Tightness • Dry & Dehyrated Skin",
            price = 355.20,
            originalPrice = 444.00,
            imageUrl = R.drawable.product_image,
            isFavourite = false,
            isInStock = false,
            isBestSeller = false,
            rating = 4.5,
            reviewsCount = 249
        )
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Shop",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        color = Color.White
                    )
                },
                navigationIcon = {
                    IconButton(onClick = {  }) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = "Back", tint = Color.White)
                    }
                },
                actions = {
                    IconWithBottomBadge(
                                    icon = Icons.Default.Search,
                                    contentDescription = "Search",
                                    badgeCount = 0,
                                    onClick = { /* Wishlist */ }
                                )
                                IconWithBottomBadge(
                                    icon = Icons.Default.FavoriteBorder,
                                    contentDescription = "Wishlist",
                                    badgeCount = 5,
                                    onClick = {  }
                                )
                                IconWithBottomBadge(
                                    icon = Icons.Default.ShoppingCart,
                                    contentDescription = "Cart",
                                    badgeCount = 3,
                                    onClick = {  }
                                )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF1E1E1E),
                    titleContentColor = Color.White,
                    actionIconContentColor = Color.White,
                    navigationIconContentColor = Color.White
                )
            )
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(Color(0xff2b2b2a))
        ) {
            item {
              OfferBannerWithImageBackground()
            }

            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Categories",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.SemiBold,
                        fontFamily = CenturyOldStyle,
                        color = Color.White
                    )
                    Text(
                        text = "See all",
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color(0xFF888888),
                        modifier = Modifier.clickable {  }
                    )
                }
                LazyRow(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp),
                    contentPadding = PaddingValues(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    items(categories) { category ->
                        CategoryItem(category = category)
                    }
                }
            }
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "New products",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.SemiBold,
                        fontFamily = CenturyOldStyle,
                        color = Color.White
                    )
                    Text(
                        text = "See all",
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color(0xFF888888)
                    )
                }
            }
            items(products.chunked(1)) { rowProducts ->
                rowProducts.forEach { product ->
                    NewProductSection(product)
                }
            }
        }
    }
}




@Composable
fun CategoryItem(category: Category) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .width(80.dp)
            .clip(RoundedCornerShape(8.dp))
    ) {
        Box(
            modifier = Modifier
                .size(80.dp)
                .clip(CircleShape)
                .background(Color.Black),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.categorysample),
                contentDescription = category.name,
                modifier = Modifier.size(60.dp)
            )
        }
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = category.name,
            style = MaterialTheme.typography.bodySmall,
            fontWeight = FontWeight.Medium,
            color = Color.White,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}



@Composable
fun NewProductSection(product: Product) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.card_grey_bg),
            contentDescription = "Grey background shape",
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.TopCenter),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp)
            ) {
                IconButton(
                    onClick = { },
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .background(Color.Black, CircleShape)
                        .size(25.dp)
                ) {
                    Icon(
                        imageVector =  if (product.isFavourite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                        contentDescription = "Favorite",
                        tint =  Color(0xFFB6A3F1)
                    )
                }
                if (product.isBestSeller) {
                    Text(
                        text = "Best seller",
                        color = Color.Green,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .align(Alignment.TopEnd)
                            .background(Color.Black, RoundedCornerShape(8.dp))
                            .padding(horizontal = 6.dp, vertical = 3.dp)
                    )
                }
            }


            Image(
                painter = painterResource(id = product.imageUrl), //
                contentDescription = product.name,
                modifier = Modifier
                    .aspectRatio(1.4f),
                contentScale = ContentScale.Fit
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight() ,
            ) {
                Image(
                    painter = painterResource(id = R.drawable.card_black_shape), //
                    contentDescription = "Black background shape for details",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    contentScale = ContentScale.FillWidth
                )

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.TopStart)
                        .padding(horizontal = 24.dp, vertical = 20.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = product.name,
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold,
                            fontFamily = Tangerine,
                            color = Color(0xFFCCFF00) // Green color for product name
                        )
                        if (product.isInStock) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Box(
                                    modifier = Modifier
                                        .size(6.dp)
                                        .clip(CircleShape)
                                        .background(Color(0xFFCCFF00))
                                )
                                Spacer(modifier = Modifier.width(4.dp))
                                Text(
                                    text = "In stock",
                                    style = MaterialTheme.typography.bodySmall,
                                    color = Color(0xFFCCFF00)
                                )
                            }
                        } else {
                            Text(
                                text = "Out of stock",
                                style = MaterialTheme.typography.bodySmall,
                                color = Color.Red,
                                fontWeight = FontWeight.SemiBold
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = product.description,
                        style = MaterialTheme.typography.bodySmall,
                        color = Color.White.copy(alpha = 0.7f),
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column {
                            Text(
                                text = buildAnnotatedString {
                                    append("₹ ${product.price}")
                                    product.originalPrice?.let {
                                        append(" ")
                                        withStyle(style = SpanStyle(textDecoration = TextDecoration.LineThrough, color = Color.White.copy(alpha = 0.5f))) {
                                            append("RS. ${it}")
                                        }
                                    }
                                },
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold,
                                color = Color.White //
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                repeat(5) {
                                    Icon(
                                        imageVector = Icons.Default.Star,
                                        contentDescription = null,
                                        tint = if (it < product.rating.toInt()) Color(0xFFFFD700) else Color.White.copy(alpha = 0.3f), // Gold for filled stars, grey for empty
                                        modifier = Modifier.size(16.dp)
                                    )
                                }
                                Spacer(modifier = Modifier.width(4.dp))
                                Text(
                                    text = "${product.reviewsCount} reviews", //
                                    style = MaterialTheme.typography.bodySmall,
                                    color = Color.White.copy(alpha = 0.7f),
                                    fontFamily = Neuzeit
                                )
                            }
                        }

                        IconButton(
                            onClick = { },
                            modifier = Modifier
                                .size(60.dp)
                                .padding(start = 24.dp, top = 12.dp)
                                .clip(RoundedCornerShape(16.dp))
                                .border(
                                    width = 2.dp,
                                    color = Color(0xFFAFDE42),
                                    shape = CircleShape
                                )

                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.cart3),
                                contentDescription = "Add to Cart",
                                tint = Color.Unspecified,
                                modifier = Modifier
                                    .size(40.dp)
                                    .padding(8.dp),
                            )
                        }
                    }
                }
            }
        }
    }
}




@Preview(showBackground = true, widthDp = 360)
@Composable
fun PreviewShopFlowScreen() {
    MaterialTheme {
        ShopFlowScreen()
    }
}

