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
import androidx.compose.animation.AnimatedVisibility
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
import androidx.lifecycle.viewmodel.viewModelFactory
import com.google.gson.Gson
import io.ktor.client.HttpClient
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment
import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import io.ktor.client.*
import io.ktor.client.call.body
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.http.HttpHeaders
import io.ktor.http.auth.AuthScheme.Bearer
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request
import java.util.UUID
import kotlin.coroutines.coroutineContext
import androidx.compose.runtime.*



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
    var mainvis by remember { mutableStateOf(false) }
    TopAppBar(title = { /*TODO*/ })
    Box(modifier = Modifier) {
        SqureType2InputForm()

        var showComposable by remember { mutableStateOf(false) }
        AnimatedVisibility(visible = showComposable) {


        }

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
    var mystring by remember{ mutableStateOf("000")}
    val context = LocalContext.current
    /* need all item properties */
    var showComposable by remember { mutableStateOf(false) }
    if (showComposable){
        numata(gstring = mystring)
    }

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

        Button(onClick = { GlobalScope.launch { var text = ApiCall();  withContext(Dispatchers.Main) {
            Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
        }}  }) {

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
 suspend fun  ApiCall(): String {
    val client = HttpClient(OkHttp)

     val response: HttpResponse = client.get("https://connect.squareupsandbox.com/v2/catalog/info"){
         headers{
             append(HttpHeaders.Authorization, "Bearer EAAAly3sXonq42CFhIpDLYr_VsJquQSKU4T6NCBqoVJk06SqW-w5vqYGtjHEN9jH")
         }
     }

      var outter =response.body<String>()

     return outter





}
@Composable
fun numata(gstring:String){
    var context = LocalContext.current
    Toast.makeText(context,gstring,Toast.LENGTH_SHORT).show()

}
@Composable
fun SqureType2InputForm() {
    // Top-level ApiResponse field
    var idempotencyKey by remember { mutableStateOf("700") }

    // ObjectData fields
    var objectId by remember { mutableStateOf("replaced") }
    var objectType by remember { mutableStateOf("Item") }

    // ItemData fields
    var abbreviation by remember { mutableStateOf("DC") }
    var description by remember { mutableStateOf("longestice ") }
    var itemName by remember { mutableStateOf("Shipping service") }

    // Variation fields (assuming a single variation for simplicity)
    var variationId by remember { mutableStateOf("ocean") }
    var variationType by remember { mutableStateOf("Ocean type") }

    // ItemVariationData fields
    var itemVariationItemId by remember { mutableStateOf("701") }
    var itemVariationName by remember { mutableStateOf("CruseShip") }
    var pricingType by remember { mutableStateOf("lit") }

    // PriceMoney fields (optional)
    var amount by remember { mutableStateOf("300") }
    var currency by remember { mutableStateOf("USD") }
    var context = LocalContext.current

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
                var pricy : SqureType2.PriceMoney = SqureType2.PriceMoney(amount.toInt(), "USD")
                var itemvar: SqureType2.ItemVariationData = SqureType2.ItemVariationData(itemVariationItemId,itemVariationName, pricingType, priceMoney = null)
                var vary :SqureType2.Variation = SqureType2.Variation(variationId, variationType, itemvar)
                var lister : List<SqureType2.Variation>  = listOf(vary)
                var idata : SqureType2.ItemData = SqureType2.ItemData(abbreviation,description,itemName, lister)
                var obbdata: SqureType2.ObjectData = SqureType2.ObjectData(objectId,objectType,idata)
                var api =  SqureType2.ApiResponse(UUID.randomUUID().toString(), obbdata)

                var gsonner : Gson = Gson()
                var Gapi = gsonner.toJson(api)

                Toast.makeText(context,api.objectData.itemData.description ,Toast.LENGTH_LONG).show()



            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Submit")
        }
    }
}
