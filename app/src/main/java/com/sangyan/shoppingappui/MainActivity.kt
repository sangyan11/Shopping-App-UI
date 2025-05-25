package com.sangyan.shoppingappui

import android.annotation.SuppressLint
import android.graphics.drawable.PaintDrawable
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.wear.compose.foundation.pager.HorizontalPager
import androidx.wear.compose.foundation.pager.rememberPagerState
import androidx.wear.compose.material3.AppScaffold
import com.google.accompanist.pager.ExperimentalPagerApi
import com.sangyan.shoppingappui.ui.theme.ShoppingAppUITheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ShoppingAppUITheme {
                ShopFlowScreen()
            }
//           ShoppingAppUITheme {
//                Scaffold(
//                    topBar = {
//                        TopAppBar(
//                            title = {
//                                Text(
//                                    text = "Shop",
//                                    color = Color.White,
//                                    fontWeight = FontWeight.Bold,
//                                    fontSize = 22.sp
//                                )
//                            },
//                            navigationIcon = {
//                                IconButton(onClick = { /* handle back */ }) {
//                                    Icon(
//                                        Icons.Default.ArrowBack,
//                                        contentDescription = "Back",
//                                        tint = Color.White
//                                    )
//                                }
//                            },
//                            actions = {
//                                IconWithBottomBadge(
//                                    icon = Icons.Default.Search,
//                                    contentDescription = "Search",
//                                    badgeCount = 0,
//                                    onClick = { /* Wishlist */ }
//                                )
//                                IconWithBottomBadge(
//                                    icon = Icons.Default.FavoriteBorder,
//                                    contentDescription = "Wishlist",
//                                    badgeCount = 5,
//                                    onClick = { /* Wishlist */ }
//                                )
//                                IconWithBottomBadge(
//                                    icon = Icons.Default.ShoppingCart,
//                                    contentDescription = "Cart",
//                                    badgeCount = 3,
//                                    onClick = { /* Cart */ }
//                                )
//                            },
//                            colors = TopAppBarDefaults.topAppBarColors(
//                                containerColor = Color.Gray,
//                                titleContentColor = Color.White
//                            )
//                        )
//                    },
//                    containerColor = Color.Gray,
//                    content = {
//                        LazyColumn {
//                            item {
//                                OfferBannerWithImageBackground(backgroundImage = painterResource(R.drawable.banner_card_foreground))
//
//                            }
//                            item {
//
//                                Row(
//                                    modifier = Modifier
//                                        .fillMaxWidth()
//                                        .padding(start = 12.dp , end = 12.dp),
//                                    horizontalArrangement = Arrangement.SpaceBetween
//                                ) {
//                                    Text(
//                                        text = "Categories",
//                                        color = Color.White,
//                                        fontWeight = FontWeight.Bold,
//                                        fontSize = 20.sp
//                                    )
//                                    Text(
//                                        text = "See all",
//                                        color = Color.White,
//                                        fontWeight = FontWeight.Bold,
//                                        fontSize = 14.sp
//                                    )
//
//                                }
//                            }
//
//                        }
//
//                    }
//                )
//            }
        }
    }
}

@Composable
fun IconWithBottomBadge(
    icon: ImageVector,
    contentDescription: String,
    badgeCount: Int,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .size(42.dp)
            .padding(end = 4.dp) // spacing between icons if needed
    ) {
        IconButton(
            onClick = onClick,
            modifier = Modifier.align(Alignment.Center)
        ) {
            Icon(
                imageVector = icon,
                contentDescription = contentDescription,
                tint = Color.White
            )
        }

        if (badgeCount > 0) {
            Box(
                modifier = Modifier
                    .size(20.dp)
                    .background(Color(0xFFB2FF59), shape = CircleShape) // Light green color
                    .align(Alignment.BottomEnd),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = badgeCount.toString(),
                    color = Color.Black,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}


@Composable
fun OfferBannerWithImageBackground(
    modifier: Modifier = Modifier,
    backgroundImage: Painter = painterResource(R.drawable.banner_card_foreground)
) {


    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 16.dp)
            .height(210.dp)
    ) {
        // Background image
        Image(
            painter = backgroundImage,
            contentDescription = "Offer Background",
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .matchParentSize()
        )


        //    Content overlay
//        Row(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(top = 120.dp, start = 20.dp, end = 20.dp),
//            horizontalArrangement = Arrangement.SpaceBetween,
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            Column() {
//                Text(
//                    text = "GET 20% OFF",
//                    color = Color.White,
//                    fontWeight = FontWeight.Bold,
//                    fontSize = 30.sp
//                )
//                Text(
//                    modifier = Modifier.padding(top = 8.dp),
//                    text = "Get 20% off",
//                    color = Color.Gray,
//                    fontSize = 14.sp
//                )
//                Row(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .padding(top = 15.dp),
//                    horizontalArrangement = Arrangement.SpaceBetween,
//                    verticalAlignment = Alignment.CenterVertically
//                ) {
//                    Box(
//                        modifier = Modifier
//                            .background(Color(0xFFCCFF00), shape = RoundedCornerShape(50))
//                            .padding(horizontal = 12.dp, vertical = 4.dp),
//                        contentAlignment = Alignment.BottomEnd
//                    ) {
//                        Text(
//                            text = "12-16 October",
//                            fontSize = 12.sp,
//                            color = Color.Black,
//                            fontWeight = FontWeight.Medium
//                        )
//                    }
//
//
//                    Box(
//                        modifier = Modifier
//                            .padding(end = 56.dp)
//                    ) {
//                        Icon(
//                            imageVector = Icons.Default.AccountCircle, // Replace with cloud-style icon
//                            contentDescription = "User",
//                            tint = Color.White,
//                            modifier = Modifier
//                                .size(40.dp)
//                        )
//                    }
//
//
//                }
//
//
//            }
//
//
//        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp, vertical = 30.dp) // Adjust overall padding for content
        ) {
            Text(
                text = "GET 20% OFF",
                color = Color.White,
                fontWeight = FontWeight.Black, // Made bolder
                fontSize = 28.sp // Increased font size
            )
            Text(
                modifier = Modifier.padding(top = 8.dp),
                text = "Get 20% off",
                color = Color.White,
                fontSize = 18.sp
            )
            Spacer(modifier = Modifier.height(15.dp)) // Use Spacer for vertical separation

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // "12-16 October" box
                Box(
                    modifier = Modifier
                        .background(Color(0xFFCCFF00), shape = RoundedCornerShape(50)) // Yellow-green color
                        .padding(horizontal = 13.dp, vertical = 2.dp),
                ) {
                    Text(
                        text = "12-16 October", //
                        fontSize = 12.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.Medium
                    )
                }

                // Person Icon
                Box (
                    modifier = Modifier
                        .padding(end = 56.dp)
                        .size(40.dp)
                ){
                    Icon(
                        painter = painterResource(R.drawable.baseline_cloud_24),
                        contentDescription = "User",
                        tint = Color.White
                    )
                }

            }
        }
    }
}


@Composable
fun PageIndicator(
    modifier: Modifier = Modifier,
    totalPages: Int = 3,
    currentPage: Int = 0,
    activeColor: Color = Color(0xFFCCFF00),
    inactiveColor: Color = Color(0xFF555555),
    indicatorSize: Dp = 15.dp,
    spacing: Dp = 8.dp
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(spacing),
        verticalAlignment = Alignment.CenterVertically
    ) {
        repeat(totalPages) { index ->
            Box(
                modifier = Modifier
                    .size(indicatorSize)
                    .background(
                        color = if (index == currentPage) activeColor else inactiveColor,
                        shape = CircleShape
                    )
            )
        }
    }
}








