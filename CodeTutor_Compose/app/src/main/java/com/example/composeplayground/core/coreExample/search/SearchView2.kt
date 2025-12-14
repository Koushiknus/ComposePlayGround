import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.composeplayground.core.coreExample.search.SearchViewModel

@Composable
fun SearchView2(viewModel: SearchViewModel) {
    //var searchQuery by mutableStateOf("")
    Column(
        modifier = Modifier.padding(16.dp).fillMaxWidth()
    ) {
       /* TextField(
       //   value = searchQuery,
           onValueChange = {} ,
            label = { Text("Search names") },
            modifier = Modifier.fillMaxWidth()
        )*/

        Spacer(Modifier.height(16.dp))

        LazyColumn(
            modifier = Modifier.padding(8.dp)
        ) {
            /*items(viewModel.filteredUsers){

            }*/
        }
    }
}

