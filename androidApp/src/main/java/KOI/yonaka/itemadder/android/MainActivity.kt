package KOI.yonaka.itemadder.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import KOI.yonaka.itemadder.Greeting
import android.renderscript.Sampler.Value
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.verticalScroll
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layout
import androidx.compose.ui.unit.dp
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainView()


        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainView() {
    TopAppBar(title = { /*TODO*/ })
    Box(modifier = Modifier) {
        Itemform()


    }

}
@Preview
@Composable
fun Itemform() {
    var Iid = ""
    var Itype = ""
    var Idata = ""
    var Idesc = ""
    var Iname = ""
    var Ivar = ""
    var Ivid = ""
    var Ivname = ""
    var myItem: SquareItem
    var Iprice: Double = 0.0
    var varHolder: List<Variation>
    var myVarry: Variation
    /* need all item properties */


    /* UI starts here*/
    Spacer(
        modifier = Modifier
            .height(45.dp)
    )
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {

        TextField(value = " ", onValueChange = { Iid = it }, label = {
            Text(
                text = "Item Id",
                modifier = Modifier
            )
        })




        TextField(value = " ", onValueChange = { Iprice = it.toDouble() }, label = {
            Text(
                text = "Price",
                modifier = Modifier
            )
        })
        TextField(value = "", onValueChange = { Idata = it }, label = {
            Text(
                text = "Item data",
                modifier = Modifier
            )
        })
        TextField(value = "", onValueChange = { Idesc = it }, label = {
            Text(
                text = "Description",
                modifier = Modifier
            )
        })
        TextField(value = "", onValueChange = { Iname = it }, label = {
            Text(
                text = "Name",
                modifier = Modifier
            )
        })
        TextField(value = "", onValueChange = { Ivar = it }, label = {
            Text(
                text = "Variations",
                modifier = Modifier
            )
        })
        TextField(value = "", onValueChange = { Ivid = it }, label = {
            Text(
                text = "V ID",
                modifier = Modifier
            )
        })

        TextField(value = "Item ID", onValueChange = { Ivid = it }, label = {
            Text(
                text = "Nombre",
                modifier = Modifier
            )
        })

        Button(onClick = {  myVarry = Variation(Ivid, Ivname, Iprice);
            var myHolder = listOf<Variation>(myVarry); myItem =
                SquareItem(Iid, Iname, Idesc, Iprice, myHolder);
//
        }) {
            Text(text = "Sumbit Item")

        }




    }
    /* UI ends here*/
    fun Yeet(myitem: SquareItem): String {
        var feedback = myitem.toString()
        return feedback

    }
}