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
import android.widget.Toast
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.currentCompositionLocalContext
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layout
import androidx.compose.ui.platform.LocalContext
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
        SqureType2InputForm()
        Itemform ()


    }

}
@Preview
@Composable
fun Itemform() {
    var Iid  by remember { mutableStateOf("") }
    var Itype  by remember { mutableStateOf("") }
    var Idata  by remember { mutableStateOf("") }
    var Idesc  by remember { mutableStateOf("") }
    var Iname   by remember { mutableStateOf("") }
    var Ivar  by remember { mutableStateOf("") }
    var Ivid  by remember { mutableStateOf("") }
    var Ivname  by remember { mutableStateOf("") }
    var myItem: SquareItem
    var Iprice  by remember { mutableStateOf("") }
    var Vprice  by remember { mutableStateOf("") }
    var varHolder: List<Variation>
    var myVarry: Variation
    val context = LocalContext.current
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

        TextField(  value = Iid, onValueChange = { newText -> Iid = newText}, label = {
            Text(
                text = "Item Id",
                modifier = Modifier
            )
        },

        )
        TextField( value = Iname, onValueChange = { newText -> Iname = newText}, label = {
            Text(
                text = "Name",
                modifier = Modifier
            )
        },
        )
            TextField( value = Idesc, onValueChange = { newText -> Idesc = newText}, label = {
                Text(
                    text = "Description",
                    modifier = Modifier
                )
            })


        TextField( value = Iprice.toString(), onValueChange = { newText2 -> Iprice = newText2}, label = {
            Text(
                text = "Price",
                modifier = Modifier
            )
        })
        TextField( value =Idata, onValueChange = { newText -> Idata = newText}, label = {
            Text(
                text = "Item data",
                modifier = Modifier
            )
        })

        TextField( value = Ivid, onValueChange = { newText -> Ivid = newText}, label = {
            Text(
                text = "V ID",
                modifier = Modifier
            )
        })

        TextField( value = Ivname, onValueChange = { newText -> Ivname = newText}, label = {
            Text(
                text = "Nombre",
                modifier = Modifier
            )
        })
        TextField( value = Vprice.toString(), onValueChange = { newText2 -> Vprice = newText2}, label = {
            Text(
                text = "Price",
                modifier = Modifier
            )
        })



        Button(onClick = {  myVarry = Variation(Ivid, Ivname, Iprice.toDouble());
            var myHolder = listOf<Variation>(myVarry); myItem =
                SquareItem(Iid, Iname, Idesc, Iprice, 0.00);


            var egress = Yeet(myItem);
            Toast.makeText(context, egress, Toast.LENGTH_SHORT).show()
        }) {
            Text(text = "Sumbit Item")

        }
        Button(onClick = { }) {

        }




    }
    /* UI ends here*/
    @Composable
    fun outer(){

    }
    fun Yeet(myitem: SquareItem): String {
        var feedback = myitem.description.toString()
        return feedback

    }


}


fun Yeet(myitem: SquareItem): String {
    var feedback = myitem.toString()
    return feedback
}
@Composable
fun SqureType2InputForm() {
    // Top-level ApiResponse field
    var idempotencyKey by remember { mutableStateOf("") }

    // ObjectData fields
    var objectId by remember { mutableStateOf("") }
    var objectType by remember { mutableStateOf("") }

    // ItemData fields
    var abbreviation by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var itemName by remember { mutableStateOf("") }

    // Variation fields (assuming a single variation for simplicity)
    var variationId by remember { mutableStateOf("") }
    var variationType by remember { mutableStateOf("") }

    // ItemVariationData fields
    var itemVariationItemId by remember { mutableStateOf("") }
    var itemVariationName by remember { mutableStateOf("") }
    var pricingType by remember { mutableStateOf("") }

    // PriceMoney fields (optional)
    var amount by remember { mutableStateOf("") }
    var currency by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        Text("ApiResponse", style = MaterialTheme.typography.titleMedium)
        OutlinedTextField(
            value = idempotencyKey,
            onValueChange = { idempotencyKey = it },
            label = { Text("Idempotency Key") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))

        Text("ObjectData", style = MaterialTheme.typography.titleMedium)
        OutlinedTextField(
            value = objectId,
            onValueChange = { objectId = it },
            label = { Text("Object ID") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = objectType,
            onValueChange = { objectType = it },
            label = { Text("Object Type") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))

        Text("ItemData", style = MaterialTheme.typography.titleMedium)
        OutlinedTextField(
            value = abbreviation,
            onValueChange = { abbreviation = it },
            label = { Text("Abbreviation") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = description,
            onValueChange = { description = it },
            label = { Text("Description") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = itemName,
            onValueChange = { itemName = it },
            label = { Text("Name") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))

        Text("Variation", style = MaterialTheme.typography.titleMedium)
        OutlinedTextField(
            value = variationId,
            onValueChange = { variationId = it },
            label = { Text("Variation ID") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = variationType,
            onValueChange = { variationType = it },
            label = { Text("Variation Type") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))

        Text("ItemVariationData", style = MaterialTheme.typography.titleMedium)
        OutlinedTextField(
            value = itemVariationItemId,
            onValueChange = { itemVariationItemId = it },
            label = { Text("Item ID") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = itemVariationName,
            onValueChange = { itemVariationName = it },
            label = { Text("Item Variation Name") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = pricingType,
            onValueChange = { pricingType = it },
            label = { Text("Pricing Type") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))

        Text("PriceMoney (Optional)", style = MaterialTheme.typography.titleMedium)
        OutlinedTextField(
            value = amount,
            onValueChange = { amount = it },
            label = { Text("Amount") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = currency,
            onValueChange = { currency = it },
            label = { Text("Currency") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {
                // When submitting, you might create your data classes like:
                // val priceMoney = if (amount.isNotBlank() && currency.isNotBlank())
                //    PriceMoney(amount.toInt(), currency)
                // else null
                //
                // val itemVariationData = ItemVariationData(
                //    itemId = itemVariationItemId,
                //    name = itemVariationName,
                //    pricingType = pricingType,
                //    priceMoney = priceMoney
                // )
                //
                // val variation = Variation(
                //    id = variationId,
                //    type = variationType,
                //    itemVariationData = itemVariationData
                // )
                //
                // val itemData = ItemData(
                //    abbreviation = abbreviation,
                //    description = description,
                //    name = itemName,
                //    variations = listOf(variation)
                // )
                //
                // val objectData = ObjectData(
                //    id = objectId,
                //    type = objectType,
                //    itemData = itemData
                // )
                //
                // val apiResponse = ApiResponse(
                //    idempotencyKey = idempotencyKey,
                //    objectData = objectData
                // )
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Submit")
        }
    }
}
