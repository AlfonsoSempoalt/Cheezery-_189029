package mx.edu.itson.practica04_chezeery_189029

import android.content.Context
import android.content.Intent
import android.os.BaseBundle
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_productos.*

class ProductosActivity : AppCompatActivity() {
    private var coldDrinks= ArrayList<Product>()
    var hotDrinks = ArrayList<Product>()
    var sweets = ArrayList<Product>()
    var salties = ArrayList<Product>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_productos)
        var img: ImageView = findViewById(R.id.tittle_coldDrinks) as ImageView
        agregarProducto()
        val intent: Intent = getIntent()
        val buttonType = intent.getStringExtra("button")


        if(buttonType.equals("coldDrinks")){
            img.setImageResource(R.drawable.colddrinks)
            var adapterProducts: AdaptadorProductos= AdaptadorProductos(this, coldDrinks)
            listVItems.adapter=adapterProducts
        }else if(buttonType.equals("hotDrinks")){
            img.setImageResource(R.drawable.hotdrinks)
            var adapterProducts: AdaptadorProductos= AdaptadorProductos(this, hotDrinks)
            listVItems.adapter= adapterProducts
        }else if(buttonType.equals("sweets")){
            img.setImageResource(R.drawable.sweets)
            var adapterProducts: AdaptadorProductos= AdaptadorProductos(this, sweets)
            listVItems.adapter=adapterProducts
        }else if(buttonType.equals("salties")){
            img.setImageResource(R.drawable.salties)
            var adapterProducts: AdaptadorProductos= AdaptadorProductos(this, salties)
            listVItems.adapter=adapterProducts
        }

     }

    fun agregarProducto(){
        coldDrinks.add(Product( "Caramel Frap", R.drawable.caramelfrap, "Caramel syrup meets coffee, milk and ice and whipped cream and buttery caramel sauce layer the love on top.", 5.toDouble()))
        coldDrinks.add(Product("Chocolate Frap", R.drawable.chocolatefrap, "Rich mocha-flavored sauce meets up with chocolaty chips, milk and ice for a blender bash.", 6.toDouble()))
        coldDrinks.add(Product("Cold Brew", R.drawable.coldbrew, "Created by steeping medium-to-coarse ground coffee in room temperature water for 12 hours or longer.", 3.toDouble()))
        coldDrinks.add(Product("Matcha Latte", R.drawable.matcha, "Leafy taste of matcha green tea powder with creamy milk and a little sugar for a flavor balance that will leave you feeling ready and raring to go.", 4.toDouble()))
        coldDrinks.add(Product("Oreo Milkshake", R.drawable.oreomilkshake, "Chocolate ice cream, and oreo cookies. Topped with whipped cream with cocoa and chocolate syrup.", 7.toDouble()))
        coldDrinks.add(Product("Peanut Milkshake", R.drawable.peanutmilkshake, "Vanilla ice cream, mixed with peanut butter and chocolate.", 7.toDouble()))

        hotDrinks.add(Product("Latte", R.drawable.latte, "Coffee drink made with espresso and steamed milk", 6.0))
        hotDrinks.add(Product("Hot chocolate", R.drawable.hotchocolate, "Heated drink consisting of shaved chocolate, topped with marshmallows.", 5.0))
        hotDrinks.add(Product("Espresso", R.drawable.espresso, "Full-flavored, concentrated form of coffee.", 4.0))
        hotDrinks.add(Product("Chai Latte", R.drawable.chailatte, "Spiced tea concentrate with milk", 6.0))
        hotDrinks.add(Product("Capuccino", R.drawable.capuccino, "A cappuccino is an espresso-based coffee drink, prepared with steamed foam.", 7.0))
        hotDrinks.add(Product("American coffee", R.drawable.americano, "Espresso with hot water", 2.0))

        sweets.add(Product("Blueberry cake", R.drawable.blueberrycake, "Vanilla cake flavor, topped with cheese topping and blueberries.", 6.0))
        sweets.add(Product("Chocolate cupcake", R.drawable.chocolatecupcake, "Chocolate cupcakes topped with butter cream and cherries", 3.0))
        sweets.add(Product("Lemon tartalette", R.drawable.lemontartalette, "Pastry shell with a lemon flavored filling", 4.0))
        sweets.add(Product("Red Velvet cake", R.drawable.redvelvetcake, "Soft, moist, buttery cake topped with an easy cream cheese frosting.", 6.0))
        sweets.add(Product("Cherry cheesecake", R.drawable. strawberrycheesecake, "This cherry topped cheesecake is positively creamy and delicious and will be your new favorite dessert.", 7.0))
        sweets.add(Product("Tiramisu", R.drawable.tiramisu, "Coffee-flavored Italian dessert", 6.0))

        salties.add(Product("Chicken crepes", R.drawable.chickencrepes, "Fine crepes stuffed with Alfredo chicken, spinach and mushrooms.", 6.0))
        salties.add(Product("Club Sandwich", R.drawable.clubsandwich, "A delicious sandwich served with french fries.", 5.0))
        salties.add(Product("Panini", R.drawable.hampanini, "Sandwich made with Italian bread  served warmed by grilling.", 4.0))
        salties.add(Product("Philly cheese steak", R.drawable. phillycheesesteak, "Smothered in grilled onions, green peppers, mushrooms, and Provolone.", 6.0))
        salties.add(Product("Nachos", R.drawable. nachos, "Tortilla chips layered with beef and   melted cheddar cheese. Served with fried beans, guacamole, pico de gallo, and sour topping.",  7.0))
    }

    private class AdaptadorProductos: BaseAdapter {
        var product= ArrayList<Product>()
        var context: Context?=null

        constructor(context: Context, product: ArrayList<Product>){
            this.product= product
            this.context=context

        }

        override fun getCount(): Int {
            return product.size
        }

        override fun getItem(position: Int): Any {
            return this.product[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            var prod= this.product[position]
            var inflator= LayoutInflater.from(this.context)
            var vista=inflator.inflate(R.layout.producto_view,null)

            var img= vista.findViewById(R.id.producto_img) as ImageView
            var nombre= vista.findViewById(R.id.producto_tittle)  as TextView
            var description= vista.findViewById(R.id.producto_description) as TextView
            var price= vista.findViewById(R.id.producto_price) as TextView

            img.setImageResource(prod.image)
            nombre.setText(prod.name)
            description.setText(prod.description)
            price.setText("$${prod.price}")
            return vista
         }
    }
}