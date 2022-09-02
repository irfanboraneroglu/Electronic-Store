package com.example.electronicstore;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ElectronicDatabaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "ElectronicStore";
    private static final int DB_VERSION = 2;
    private static final String TABLE_NAME= "ITEM";

    public ElectronicDatabaseHelper(Context context) {

        super(context, DB_NAME, null, DB_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        updateMyDatabase(sqLiteDatabase, 0, DB_VERSION);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        updateMyDatabase(sqLiteDatabase, oldVersion, newVersion);
    }

    public void UpdateOneRow(SQLiteDatabase db,String id, String category,String name, String price, String description, int resourceId, int star) {
        ContentValues itemValues = new ContentValues();
        itemValues.put("CATEGORY", category);
        itemValues.put("NAME", name);
        itemValues.put("PRICE", price);
        itemValues.put("DESCRIPTION", description);
        itemValues.put("IMAGE_RESOURCE_ID", resourceId);
        itemValues.put("STAR", star);
        db.update("ITEM", itemValues, "_id = ?", new String[]{id});
    }

    private static void insertItem(SQLiteDatabase db,String category,String name, String price, String description, int resourceId, int star) {
        ContentValues itemValues = new ContentValues();
        itemValues.put("CATEGORY", category);
        itemValues.put("NAME", name);
        itemValues.put("PRICE", price);
        itemValues.put("DESCRIPTION", description);
        itemValues.put("IMAGE_RESOURCE_ID", resourceId);
        itemValues.put("STAR", star);
        db.insert("ITEM", null, itemValues);

    }

    Cursor SearchDueToCategory(String SearchValue){

        SQLiteDatabase db= this.getReadableDatabase();

        Cursor cursor= null;
        if(db != null){
            cursor=db.rawQuery("SELECT * FROM ITEM WHERE CATEGORY = '" + SearchValue + "'", null);
        }
        return cursor;
    }


    private void updateMyDatabase(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion < 1) {
            db.execSQL("CREATE TABLE ITEM (_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "CATEGORY TEXT, "
                    + "NAME TEXT, "
                    + "PRICE TEXT, "
                    + "DESCRIPTION TEXT, "
                    + "IMAGE_RESOURCE_ID INTEGER, "
                    + "STAR INTEGER);");


            insertItem(db, "Laptop", "ASUS Zephyrus","20.500TL", "Model: ASUS ROG Zephyrus GA401\n" +
                    "Form/Style: Standard\n" +
                    "Model No: GA401QM-211.ZG14\n" +
                    "Processor: 4th Gen AMD Ryzen 9 5900HS 3.10GHz Processor (upto 4.6 GHz, 16MB Cache, 8-Cores)\n" +
                    "Memory: 16GB DDR4 RAM (8GB Onboard + 8GB SO-DIMM)\n" +
                    "Graphics: NVIDIA RTX 3060 6GB GDDR6 Graphics,\n" +
                    "Storage: 1TB PCIe SSD (Solid State Drive)\n" +
                    "Operating System: Windows 10 Home-64\n" +
                    "Display: 14.0\" Full HD (1920x1080) 144Hz Refresh Rate 16:9 Display,\n" +
                    "Connectivity: 802.11ax Wifi, Bluetooth 5.1,\n" +
                    "Ports/Slots:, 2 USB 3.2 Gen1, 1 HDMI, 2 USB 3.2 Type-C Gen2, Headphone/Microphone Combo Jack\n" +
                    "Input/Output: No Webcam,\n" +
                    "Battery: 180W Power Supply, 4-Cell 76WHr Battery\n" +
                    "Other Features,\n" +
                    "Color: Moonlight White\n" +
                    "Weight: 3.60lb\n" +
                    "Product Dimensions (WxLxH): 12.75 IN x 8.66 IN x .75 IN\n" +
                    "1 Year Manufacturer warranty from MichaelElectronics2 (Professionally upgraded by MichaelElectronics2)", R.drawable.laptop1,3);
            insertItem(db, "Laptop", "Lenovo Legion 5","15.300TL", "Legion 5 17\" Purpose-Built Gaming Performance. Experience today’s top AAA games on the Lenovo™ Legion 5. Inside the clean, minimalist chassis of the Legion 5, available in Phantom Blue, is everything you ever need to compete on equal footing with the pros, including the latest generation AMD Ryzen™ processor and NVIDIA® GeForce RTX™graphics for performance that’s AI-optimized by the Legion AI Engine powering the revolutionary Legion Coldfront 3.0 and Q Control. Excel across every AAA title with a 17\" FHD display at up to 144 Hz refresh rate, featuring 72% NTSC color accuracy and support for Dolby Vision®, as well as the new Nahimic 3D audio and the legendary Legion Truestrike keyboard so you can strike with pinpoint precision.\n" +
                    "3.3 GHz AMD Ryzen 5 5600H Six-Core\n" +
                    "8GB DDR4 RAM\n" +
                    "256GB NVMe TLC SSD\n" +
                    "17.3\" 1920 x 1080 IPS Display", R.drawable.laptop2,2);
            insertItem(db, "Laptop", "Acer Nitro 5","14.000TL", "Acer Nitro 5 AN515-57-5700, 15.6\" Full HD IPS 144Hz Display, 11th Gen Intel Core i5-11400H, NVIDIA GeForce RTX 3050Ti Laptop GPU, 16GB DDR4, 512GB NVMe SSD, Killer WiFi 6, Killer Ethernet E2600, Backlit Keyboard, Windows 11 Home\n" +
                    "The latest 11th Gen Core i5 processor from Intel® delivers unmatched speed and intelligence, enabling impressive gaming, productivity and creating experiences with faster Wi-Fi 6 connectivity. When you’re challenging your buddies in the latest battle, you’ll be confident knowing you’ve got the power of an 11th Generation Intel® Core™ i5 processor.\n" +
                    "The new NVIDIA® GeForce RTX™ 3050Ti laptop GPU is powered by the awardwinning Ampere architecture—NVIDIA’s 2nd gen RTX —with new Ray Tracing Cores, Tensor Cores, and streaming multiprocessors for the most realistic raytraced graphics and cutting-edge AI features. The ultimate performance for gamers.\n" +
                    "Explore games in greater detail with the sharp visuals of a 15.6” FHD IPS 144Hz display with improved screen-to-body ratio to 80% with narrow 0.28\" bezels. Its hard-edged sleek lines and the red backlit keyboard light up the Nitro 5 evoking the gaming spirit. The Nitro 5 looks and feels like it will help you take control.", R.drawable.laptop3,3);
            insertItem(db, "Laptop", "MSI GF63 Thin","17.000TL", "MSI GF63 Thin 10SCXR-222 15.6\" Gaming Laptop Intel Core i5-10300H GTX1650 8GB 256GB NVMe SSD Win10\n" +
                    "Model #: GF63 Thin 10SCXR-222\n" +
                    "Graphic Card: NVIDIA GeForce® GTX1650 Max-Q\n" +
                    "Processor: Intel® Core i5-10300H\n" +
                    "Memory: 8GB DDR4 2666MHz\n" +
                    "Storage: 256GB NVMe SSD\n" +
                    "Battery Life: 51Wh\n" +
                    "Weight: 4.1 lbs\n" +
                    "Thin & Light aluminum hair-brushed aesthetics - Metallic top and keyboard cover paired with an unique X-shaped ventilation hidden underneath.\n" +
                    "High-Res Audio - Immerse yourself in lossless music and enjoy the premium sound quality with Hi-Resolution Audio. Experience and listen to audio the way it was intended.\n" +
                    "MSI Dragon Center - Software that helps you control and customize your MSI laptop the way you want. Monitor, adjust and optimize easily through one unified system.", R.drawable.laptop4,2);
            insertItem(db, "Laptop", "Lenovo IdeaPad 3","14.100TL", "Run your favorite PC games smoothly, the way they were meant to be enjoyed with NVIDIA GeForce GTX graphics, AMD Ryzen 5000 H-Series processors, and DDR4 memory. These powerful features ensure that you can run games on high settings so that you will always have the advantage of " +
                    "seeing every detail in your gaming environment. The IdeaPad Gaming 3 AMD laptop delivers victory with a display that accommodates quick reflexes. A 15.6\" FHD display with a 120Hz refresh rate keeps visuals crisp and " +
                    "tear-free so you can acquire multiple in-game targets and rack up killstreaks like a legend. And with an HDMI 2.0 port, you can easily plug in to an extra monitor or TV to get the full experience. Jump in the cockpit with controls that set you up for glorious victory. The IdeaPad Gaming 3's spacious keyboard was designed for gamers, with 1.5mm key-travel " +
                    "for ultimate control, and white backlighting to aid in key visibility in any lighting situation.", R.drawable.laptop5,1);
            insertItem(db, "Laptop", "MSI Modern 14","18.700TL", "Modern 14 Let your passion keep up with your dynamic lifestyle. Whether you are exploring new chapter in life or pursuing your career, with the latest 11th Gen. Intel® Core™ i7 processors and up to NVIDIA® discrete graphics, you will breathtaking new wonders through the Modern series.\n" +
                    "Color Vibes Bluestone mirrors the clear blue skies in the first light of day. Beige Mousse gives off sun-kissed vibes during sunny afternoons. Carbon gray stands for your unique taste as the mystery evening. Contemporary styling and sandblasted texture, the daily companion is decorated by moderate tones and an understated design.\n" +
                    "Reveal Unbounded Performance The Modern Series features the latest 11th Gen. Intel® Core™ i7 processor, delivering stunning performance and lightweight portability which will keep you in the workflow seamlessly. Especially with Intel Iris® Xe graphics, it provides uncompromised performance to empower your productivity.\n" +
                    "Accelerate Your Laptop with Dedicated Graphics (Optional) The NVIDIA® GeForce® MX450 accelerates your laptop for work and play. Now, you can expect even faster performance over the latest integrated graphics for photo editing, video editing, and gaming. It also works seamlessly with NVIDIA Optimus® technology to give you the perfect balance between long battery life and performance.", R.drawable.laptop6,3);



            insertItem(db, "Television", "SAMSUNG 55inc","5.400TL", "Get enhanced smart capabilities with the TU7000. Crystal Processor 4K automatically upscales your favorite movies, TV shows and sports events to 4K. Smart TV powered by Tizen lets you find content and navigate streaming services easily. PurColor fine tunes colors while HDR steps up to millions of shades of color that go beyond what HDTV can offer. And Edge LEDs with Contrast Enhancer use intelligent backlighting to sharpen visuals and improve clarity.\n" +
                    "\n" +
                    "Crystal Processor 4K\n" +
                    "Powerful picture quality\n" +
                    "The ultra-fast processor transforms everything you watch into stunning 4K.", R.drawable.tv1,3);
            insertItem(db, "Television", "TCL 55inc","4.100TL", "The 4-Series Roku TV delivers stunning 4K picture quality with four times the resolution of Full HD for enhanced clarity and detail, as well as endless entertainment with thousands of streaming channels. High dynamic range (HDR) technology delivers bright and accurate colors for a lifelike viewing experience. In addition, your favorite HD shows, movies, and sporting events are upscaled to near Ultra HD resolution with 4K Upscaling. The simple, personalized home screen allows seamless access to thousands of streaming channels, plus your cable box, Blu-ray player, gaming console, and other devices without flipping through inputs or complicated menus. The super-simple remote - with about half the number of buttons on a traditional TV remote - puts you in control of your favorite entertainment.\n" +
                    "\n" +
                    "Stunning 4K UHD Picture with High Dynamic Range\n" +
                    "\n" +
                    "Stunning 4K UHD picture performance with high dynamic range (HDR) technology offers exceptional clarity and detail.\n" +
                    "Thousands of Streaming Channels\n" +
                    "\n" +
                    "Enjoy the over 500,000 movies and TV episodes available to stream plus sports, news, music, kids and family, food, science and tech, fitness, foreign language and so much more.", R.drawable.tv2,1);
            insertItem(db, "Television", "LG 65inc","5.900TL", "Real 4K clarity. A full display for fuller entertainment. It's Ultra High Definition in a real 4K display for four times the resolution of Full HD. A powerful processor enhances color, contrast, and clarity, while webOS and LG Channels deliver a huge library of content right to your fingertips. There' more to love about your TV. LG UHD checks off your wishlist of features without the price tag. Ultra High Definition displays detail the 4K resolution you demand. Picture quality delivers on color, contrast and clarity. Smart features open more control to your home and entertainment. The LG 65\" 4K UHD UN6955 Smart TV is beautiful entertainment at a beautiful price.", R.drawable.tv3,3);
            insertItem(db, "Television", "Philips 65inc","5.500TL", "Philips 65\" Class 4K Ultra HD (2160p) Android Smart LED TV with Google Assistant (65PFL5766/F7):\n" +
                    "Enjoy the beauty of 4K Ultra HD\n" +
                    "\n" +
                    "4K UHD brings your TV experience to a whole new level\n" +
                    "HDR 10 delivers more detail and captivating colors\n" +
                    "Stunning brightness and contrast with BrightPro\n" +
                    "Wireless LAN 802.11ac MIMO for seamless streaming\n" +
                    "AndroidTV with the Google Assistant Built-in\n" +
                    "\n" +
                    "AndroidTV, endless entertainment options for everyone\n" +
                    "Your own Personal Google Assistant, always ready to help\n" +
                    "Expand your entertainment library with the Google Play Store\n" +
                    "Wirelessly mirror your smartphone directly onto your TV", R.drawable.tv4,2);
            insertItem(db, "Television", "Sony 75inc","19.900TL", "Sony XR75X90J 4K Smart TV, HDR, Bravia Smart TV, 74.5 Inch Diagonal, 300 x 300 Vesa Pattern, Wi-Fi Certified, 1 Ethernet, Bluetooth, Built Activated Assistant Compatible, 1 RF Input, 1 Composite Jack, 1 RS-232C, 4 HDMI, HDCP, HDMI-CEC, 1 Digital Audio Output, 1 Headphone Output, 2 USB, LCD Display, 3840 x 2160 Resolution, Full Array LED Backlighting, Local Dimming, Cognitive Processor XR, Dual Database Processing, XR Smoothing, XR Triluminous Pro, Dynamic Contrast Enhancer, XR Contrast Booster, XR HDR Remaster, XR Motion Clarity, Optimized Picture Modes Include: Vivid, Standard, Cinema, IMAX Enhanced, Game, Graphics, Photo, Custom, Dolby Vision Bright, Dolby Vision Dark, Netflix calibrated, Built in Light Sensor, 20W Speaker Output Power, 2 Full Range Bass Reflex Speakers, 2 Tweeters, DTS Digital Surround Sound, Room and User Position Compensation, Voice Zoom 2, 3D Surround Upscaling, 16 GB On-Board Storage, Sleep Timer, Auto Calibration, Closed Caption, Flush Surface Bezel, Standard Remote Control, Text Magnification, (66\"W x 16.25\"D x 41\"H)\n" +
                    "\n" +
                    "Crystal Processor 4K: This ultra-fast processor transforms everything you watch into stunning 4K\n" +
                    "HDR: Unveils shades of color you can't find on HDTV\n" +
                    "X-Motion Clarity – Advanced motion control for smooth pictures that are brighter and clearer; significantly benefiting fast-moving action in movies and sports\n" +
                    "4K X-Reality Pro – Our unique 4K database upscales all the HD content you love to near-4K resolution bringing back real-world detail and texture", R.drawable.tv5,3);
            insertItem(db, "Television", "LG 55inc","10.000TL", "The LG NanoCell 90 Series 2021 55\" 4K Smart UHD TV w/ AI ThinQ provides and eye-opening LED experience! Experience detailed LED picture in 4K resolution. With Full Array Dimming, you'll witness deep blacks and contrast with precisely balanced lighting that reduces halo effect and light bleed. See the natural, lifelike picture of Nano Color and fast action of a 120Hz refresh rate. It's an experience backed by AI Picture and AI Sound, our premium processor, connected home features and gaming tech. The LG 55\" NanoCell 90 Series TV allows you to explore a new world of color with the Real 4K NanoCell Display with Full Array Dimming. Bring cinema home with LG NanoCell 90 Series TV's Cinema HDR, Dolby Vision IQ and Dolby Atmos.\n" +
                    "Real 4K NanoCell Display w/ Full Array Dimming - Explore a new world of color.\n" +
                    "Bring your favorite shows to life with a billion rich colors.* Get deep blacks and enhanced contrast for a more detailed picture with Full Array Dimming. *Achieved through 10 bit dithering. \n" +
                    "α7 Gen 4 Processor 4K with AI Picture & AI Sound - Crystal-clear images driven by a powerful processor.\n" +
                    "Catch every detail with the smooth, crisp picture brought to you by our a7 Gen 4 AI Processor 4K. It adjusts your viewing and audio settings automatically with AI Picture and AI Sound, while AI 4K Upscaling authentically calibrates every scene.", R.drawable.tv6,3);


            insertItem(db, "MobilePhone", "iPhone 11 Pro","10.100TL", "Pro cameras. Pro display. Pro performance. Three cameras. Unlimited possibilities. Three up your camera game. The most advanced iPhone yet. Upgrade to the best iPhone yet. Shoot amazing videos and photos with the Ultra Wide, Wide, and Telephoto cameras. Capture your best low-light photos with Night mode. Watch HDR movies and shows on the Super Retina XDR display the brightest iPhone display yet. Experience unprecedented performance with A13 Bionic for gaming, augmented reality (AR), and photography. And get all-day battery life and a new level of water resistance. All in the first iPhone powerful enough to be called Pro.\n" +
                    "\n" +
                    "Key Features: \n" +
                    "\n" +
                    "5.8-inch Super Retina XDR OLED display\n" +
                    "Water and dust resistant (4 meters for up to 30 minutes, IP68)\n" +
                    "Triple-camera system with 12MP Ultra Wide, Wide, and Telephoto cameras\n" +
                    "iOS 13 with Dark Mode, new tools for editing photos and video, and brand new privacy features", R.drawable.phone1,2);
            insertItem(db, "MobilePhone", "Galaxy S20 FE","8.200TL", "6.5-inch FHD+ Dynamic AMOLED 2X Infinity-O Display, 120Hz, HDR10+, 1080 x 2400 pixels, IP68 for water and dust resistant\n" +
                    "128GB ROM, 6GB RAM, Exynos 990 (7 nm+), Octa-core, Adreno 650, Android 10, One UI 2.5, 4500mAh Battery\n" +
                    "Rear Camera: 12MP Ultra-Wide + 12MP Wide-angle + 8MP Telephoto, Front Camera: 32MP, Under Display Fingerprint\n", R.drawable.phone2,3);
            insertItem(db, "MobilePhone", "Galaxy S21","15.000TL", "With the Samsung Galaxy S21 5G in Gray from Straight Talk, you can capture life exactly as it is, or turn it into a work of art with 8K video capability. Take and share beautifully detailed portraits, stunning landscapes and crisp super close-ups with our 64MP camera system. Make the details count with 30x Space Zoom at the pinch of your fingers. Create share-ready videos and gifs in a single take with on-the-spot with multi-cam recording and automatic pro-style effects. The adaptive 120Hz display makes scrolling feel faster and silky smooth while also " +
                    "being easy on the eyes. The all-day intelligent battery and Hyper Fast Processor will make sure your work goes uninterrupted and the built-in 5G connectivity means you can send, share and stream in a flash.", R.drawable.phone3,3);
            insertItem(db, "MobilePhone", "Xiaomi Mi 11","8.100TL", "The smartphone is powered by the Qualcomm SM7150 Snapdragon 732G Octa-core processor. The smartphone comes with a 6.55 inches and 1080 x 2400 pixels resolution. It is protected by Corning Gorilla Glass 5.\n" +
                    "\n" +
                    "The rear camera consists of triple-camera: 64 MP (wide) + 8 MP (ultrawide) + 5 MP (macro) while on the front there is a 16 MP (wide). The sensors integrated into the device are Fingerprint (side-mounted), accelerometer, gyro, proximity, and compass.\n" +
                    "The smartphone is fueled by a Non-removable Li-Po 4250 mAh battery + Fast charging 33W. The phone runs on the Android 11 + MIUI 12 operating system. Xiaomi Mi 11 Lite comes in three colors: Boba Black, Peach Pink, and Bubblegum Blue.\n" +
                    "It features a USB Type-C 2.0, USB On-The-Go, GPS with dual-band A-GPS, GLONASS, BDS, GALILEO. The smartphone is pack with 6 GB and 8 GB RAM with 64 GB and 128 GB internal storage. The storage can be increased with the help of microSDXC (uses shared SIM slot).\n" +
                    "Internet Browser,Dual SIM,Touchscreen,3G Data Capable,4G Data Capable,Accelerometer,Bluetooth Enabled,Music Player,Speakerphone", R.drawable.phone4,2);
            insertItem(db, "MobilePhone", "Xiaomi Mi 10T","6.300TL", " Display: 6.67\" IPS LCD, 1080x2400px resolution, 20:9 aspect ratio, 395ppi; HDR10+, 144Hz refresh rate. Chipset: Qualcomm SM8250 Snapdragon 865 (7 nm+): Octa-core (1x2.84 GHz Kryo 585 & 3x2.42 GHz Kryo 585 & 4x1.80 GHz Kryo 585); Adreno 650. Memory: 128GB 8GB RAM, 256GB 8GB RAM; UFS 3.1. OS/Software: Android 10, MIUI 12. Rear camera: Wide (main): 108 MP, f/1.7, 26mm, 1/1.33\", 0.8µm, PDAF, OIS; Ultra wide angle: 13 MP, f/2.4, 123˚, 1.12µm; Macro: 5 MP, f/2.4, AF; LED flash, HDR, panorama. Front camera: 20 MP, f/2.2, 27mm, 1/3.4\", 0.8µm; HDR. Video capture: Rear camera: 8K@30fps, 4K@30/60fps, 1080p@30/60/120/240/960fps; gyro-EIS; Front camera: 1080p@30fps, 720p@120fps. Battery: 5000mAh; Fast charging 33W," +
                    " Power Delivery 3.0. Misc: Fingerprint (side-mounted); NFC; stereo loudspeakers; IR blaster; .", R.drawable.phone5,1);
            insertItem(db, "MobilePhone", "iPhone 12 ","14.600TL", "Welcome to the new era of iPhone. With the iPhone 12 in White from Straight Talk, you can use the ultrafast 5G to download huge files on the go and stream HDR video anytime anywhere. Take it all in with the beautifully bright 6.1-inch Super Retina XDR display2 that’s protected with Ceramic Shield with 4x better drop performance.3 Take stunning photos, even at night with incredibly low-light photography with a new advanced dual-camera system. Edit photos, browse and multitask better than ever with the powerful A14 Bionic chip.\n" +
                    "\n" +
                    "6.1-inch Super Retina XDR display2\n" +
                    "Ceramic Shield, tougher than any phone glass\n" +
                    "5G for superfast downloads and high-quality streaming1\n" +
                    "A14 Bionic chip, the fastest chip ever in a phone\n" +
                    "Advanced dual-camera system with 12MP Ultra Wide and Wide cameras; Night mode, Deep Fusion, Smart HDR 3, Apple ProRAW,5 4K Dolby Vision HDR recording\n" +
                    "12MP TrueDepth front camera with Night mode, 4K Dolby Vision HDR recording\n" +
                    "Industry-leading IP68 water resistance6\n" +
                    "Supports MagSafe accessories for easy attach and faster wireless 4\n" +
                    "iOS 14 with redesigned widgets on the Home screen, all-new App Library, App Clips, and more", R.drawable.phone6,3);

            insertItem(db, "Smartwatch", "Apple Watch 7","4.100TL", "The largest, most advanced Always-on Retina display yet makes everything you do with your Apple Watch\n" +
                    "Series 7 bigger and better. Series 7 is the most durable Apple Watch ever built, with an even more crack-resistant front crystal. Advanced features let you measure your blood oxygen level,1 take an ECG anytime,2 and access mindfulness and sleep tracking apps. You can also track dozens of workouts, including new tai chi and pilates.\n" +
                    "\n" +
                    "Always-on Retina display has nearly 20% more screen area than Series 6, making everything easier to see and use\n" +
                    "The most crack-resistant front crystal yet on an Apple Watch, IP6X dust resistance, and swimproof design3\n" +
                    "Measure your blood oxygen with a powerful sensor and app1\n" +
                    "Take an ECG anytime, anywhere2\n" +
                    "Get high and low heart rate, and irregular heart rhythm notifications4\n" +
                    "Stay in the moment with the new Mindfulness app, and reach your sleep goals with the Sleep app\n" +
                    "Track new tai chi and pilates workouts, in addition to favorites like running, yoga, swimming, and dance\n" +
                    "Track your daily activity on Apple Watch, and see your trends in the Fitness app on iPhone\n" +
                    "Sync your favorite music, podcasts, and audiobooks\n" +
                    "Pay instantly and securely from your wrist with Apple Pay\n" +
                    "All-day battery life and faster charging5", R.drawable.watch1,3);
            insertItem(db, "Smartwatch", "SAMSUNG Watch 4","3.600TL", "Crush your health and wellness goals every day with the watch that gets you\n" +
                    "Crush workouts and all your health goals with Samsung Galaxy Watch4, the smartwatch that gets you. Push yourself to the next level with Auto Workout Tracking, Advanced Run Coaching, and Group Challenges. Track heart and lung endurance with oxygen level monitoring.1 Combining style and function, Galaxy Watch4 offers a number of fashionable bands to match your every mood and all-day comfort to keep you looking great from the locker room to the conference room. Staying on top of your day on the go is a breeze with Google app integration and call-text-notification connectivity. Galaxy Watch4 delivers " +
                    "everything you need to conquer your day, no matter where you are or what’s on your plate.\n", R.drawable.watch2,2);
            insertItem(db, "Smartwatch", "Garmin Venu® 2S","4.400TL", "When you live healthily, you live better. Get in tune with your mind and body with Venu® 2. This GPS smartwatch has advanced health monitoring and fitness features to help you better understand what’s going on inside your body. It feels good to move. Switch up your activities with animated workouts and more than 25 built-in indoor and GPS sports apps. Feed your soul with your favorite music, stored right on your wrist for phone-free listening when paired with wireless headphones (sold separately). And the battery life of up to 5 days with rapid recharging lets you get an uninterrupted picture of your health. This is what it’s all about. Mind and body; connected by Garmin.\n" +
                    "\n" +
                    "Suit your style with a smartwatch that's available in two colors and features a bright AMOLED display\n" +
                    "Know your body better with extensive health monitoring features including health snapshot, Body Battery trade; energy levels, sleep score, fitness age, stress tracking, and more (this device is intended to be an estimation of your activity and metrics; it is not a medical device)", R.drawable.watch3,3);
            insertItem(db, "Smartwatch", "SAMSUNG Galaxy Watch","2.900TL", "Bluetooth only Live a stronger, smarter life with Galaxy Watch at your wrist. Rest well and stay active with built-in health tracking and a Bluetooth connection that keeps everything at your wrist. 1 Plus, go for days without charging. LTE Live a stronger, smarter life with the watch that lets you break free from your phone and stay connected with cellular.2 Rest well and stay active with health tracking tools, and go for days without charging. With Galaxy Watch, everything you need is at your wrist. Bluetooth & LTE Live a stronger, smarter life with the watch that lets you stay connected without reaching for your phone. 1, 2 Rest well and keep active with built-in health tracking and go for days without charging. With Galaxy Watch, everything you need is at your wrist.\n" +
                    "\n" +
                    "\n" +
                    "SAMSUNG Galaxy Watch - LTE Smart Watch (46mm) Silver - SM-R805UZSAXAR\n" +
                    "Your most balanced life- Balance mind and body with sleep cycle tracking, reminders to keep moving, calorie tracking, guided meditation, and breathing exercises for stress management.\n" +
                    "Go for days- Go nonstop for days on a single charge. The wireless charger lets you power up without slowing down.\n" +
                    "Leave your phone behind- Leave your phone at home. With Galaxy Watch, you have the freedom to call, text, stream music and get notifications via cellular.", R.drawable.watch4,2);
            insertItem(db, "Smartwatch", "Amazfit GTS ","1.100TL", "Amazfit GTS comes with 14-day battery life, 24/7 heart rate and activity tracking 1.66 inch AMOLED touchscreen compatible with select Android and iOS devices including iPhone and iPad models and select cell phones and tablets with Android for simple wireless communication. Smart connectivity Amazfit features smart notifications, music controls and personalization through free watch faces available in the watch store. Brilliant 1.65\" Amoled high Retina Display offers easy navigation and clear visuals with 454 x 454 resolution. Water-resistant design defends your smartwatch against submersion in up to 164' of water. Wireless connection to your device The Bluetooth technology enables a reliable Wire-free connection. Comprehensive monitoring GTR tracks heart rate, sleep quality," +
                    " calories burned, steps taken and more. Multisport tracking this smartwatch boasts 17 Sport tracking modes, including outdoor/indoor running, walking, outdoor/indoor cycling, elliptical trainer, pool/open water swimming, etc.", R.drawable.watch5,1);
            insertItem(db, "Smartwatch", "iTech Fusion","300TL", "Looking for a smartwatch that won't break the bank? The iTech Fusion smartwatch includes high tech features at an affordable price, exclusively at Walmart. The iTech Fusion watch doubles as a fitness tracker - including a calorie counter, pedometer, and a sleep monitor! Receive phone notifications, weather forecasts, and control music right from your wrist! So many great features on a full touchscreen dial! Keep up with your busy lifestyle with the iTech Fusion smartwatch. Complete with convenience, this watch features a motion gesture, so you'll be able to view the screen just by turning your wrist.", R.drawable.watch6,1);


            insertItem(db, "Headphone", "Beats Solo Pro","2.500TL", "Sound Inspired\n" +
                    "Get inspired with Solo Pro wireless headphones. To deliver sound how you want it, Solo Pro features two listening modes: Active Noise Cancelling (ANC) and Transparency. Beats Pure ANC gives you the space to create with fully immersive sound, while Transparency helps you stay aware of your surroundings. Every detail of Solo Pro has been carefully considered, right down to the intuitive way the headphones turn on and off via folding. The ergonomic design delivers exceptional comfort for extended wear and sleek style. And with up to 22 hours of battery life, you " +
                    "can keep the music going no matter where your day takes you.\n", R.drawable.head1,3);
            insertItem(db, "Headphone", "JBL T510BT","650TL", "The Tune 510BT Wireless On-Ear Headphones from JBL are packed with features to give you a complete portable audio experience without the need to interact with your mobile devices. Bluetooth technology lets you stream your favorite music, podcasts, and more through 32mm dynamic drivers. When paired with your smartphone, you can use integrated controls and built-in microphone to take hands-free calls. To give voice commands to Siri or Google Assistant through the mic, simply press the multi-function button to activate them. The Tune 510BT headphones " +
                    "can even automatically switch between devices thanks to multi-point support.", R.drawable.head2,2);
            insertItem(db, "Headphone", "JBL Live 650BT","1.500TL", "In your world, music is essential, so slip on a pair of JBL Live 650 BT On-Ear Wireless Headphones and elevate your day. Equipped with powerful 40mm drivers, these headphones deliver JBL signature sound punctuated with enhanced bass so every track on every playlist pops. And when the music is the only thing that matters, the active noise-cancelling technology allows you to block-out ambient sounds so nothing disturbs your groove. Need some help getting through the day. Easily access the Google Assistant or Amazon Alexa with a tap on the ear cup and play your favorite playlist, text your friend or check the weather and much more, without glancing at your phone. But that's not all. With a cool, lightweight and comfortable design, you'll enjoy up to 30 hours of " +
                    "music streaming with two hours of recharging time, multi-point connection capabilities and a convenient detachable cable with remote/mic, that lets you play on even when the battery goes off. Rock out uninterrupted with the JBL Live 650 BT On-Ear Wireless Headphones.", R.drawable.head3,3);
            insertItem(db, "Headphone", "Beats Studio3","2.300TL", "Beats Studio3 Wireless headphones deliver a premium listening experience with Pure Adaptive Noise Canceling (Pure ANC) to actively block external noise, and real-time audio calibration to preserve clarity, range, and emotion.\n" +
                    "Key Features\n" +
                    "\n" +
                    "Pure Adaptive Noise Canceling (Pure ANC) actively blocks external noise\n" +
                    "Real-time audio calibration preserves a premium listening experience\n" +
                    "Up to 22 hours of battery life enables full-featured all-day wireless playback\n" +
                    "Apple W1 chip for Class 1 Wireless Bluetooth connectivity & battery efficiency\n" +
                    "With Fast Fuel, a 10-minute charge gives 3 hours of play when battery is low\n" +
                    "Pure ANC-off for low power mode provides up to 40 hours of battery life\n" +
                    "Take calls, control music, and activate Siri with multifunction on-ear controls\n" +
                    "Soft over-ear cushions for extended comfort and added noise isolation", R.drawable.head4,3);
            insertItem(db, "Headphone", "Sony WH1000XM3","4.000TL", "Sony's industry-leading noise cancellation evolves to further immerse you in your music. The addition of Sony's proprietary HD Noise Canceling Processor QN1 masterfully reduces the ambient noise around you. Listen all day with up to 30 hours of battery life. Quick charging gives five hours of playback with just a 10-minute charge. (This item has been discontinued by manufacturer, but is still available for purchase here)\n" +
                    "Industry-leading noise canceling brings Only Music, Nothing Else\n" +
                    "Premium Sound Quality from 40mm Liquid Crystal Polymer drivers\n" +
                    "Up to 30-hour battery life with quick charging (10 min charge for 5 hours of playback)\n" +
                    "Smart Listening by SENSE ENGINE\n" +
                    "Quick Attention Mode for effortless conversations without taking your headphones off", R.drawable.head5,3);
            insertItem(db, "Headphone", "Anker Soundcore","600TL", "Brand Soundcore Color Black Connectivity Technology Wireless Model Name AK-A3025011 Form Factor Over Ear About this item Incredible Sound Loved by 20 Million+ People Hi-Res Audio: Custom oversized 40 mm dynamic drivers produce Hi-Res sound. Life Q20 active noise canceling headphones reproduce music with extended high frequencies that reach up to 40 kHz for extraordinary clarity and detail. Reduce Ambient Noises By Up to 90%: Our team of engineers conducted more than 100,000 tests in real-life scenarios to fine-tune Life Q20’s 4 built-in ANC microphones and digital active noise cancellation algorithm." +
                    " As a result, the hybrid active noise cancellation can detect and cancel out a wider range of low and mid-frequency noises such as cars and airplane engines. 100% Stronger Bass: Our exclusive BassUp technology conducts real-time analysis of the low frequencies to instantly strengthen the bass output. Double press the play button when listening to bass-heavy genres like EDM and hip-hop for an amplified listening experience. 40-Hour Playtime*: Up to 40 hours of non-stop playtime in wireless active noise cancellation mode (at 60% volume) is extended to an enormous 60 hours in standard music mode. A single charge gives you enough juice to listen to over 600 songs or soundtrack multiple long haul flights. And when you’re in a rush, charge Life Q20 active noise canceling headphones for 5 minutes and get 4 hours of listening.", R.drawable.head6,2);



            insertItem(db, "Mouse", "Logitech G502","1.100TL", "Game faster and more accurately with G502 LIGHTSPEED. Enter the iconic gaming mouse from Logitech G now with superfast LIGHTSPEED wireless, redesigned internals, and POWERPLAY compatibility. An icon among gamers, the G502 has topped the charts through every generation launched. The new G502 LIGHTSPEED honors the original by keeping the shape and layout unchanged. However the internal structure and nearly every component has been meticulously redesigned to accommodate LIGHTSPEED and POWERPLAY technologies. The G502 LIGHTSPEED uses advanced thin wall design as low as 1.2mm and an internal endoskeleton structure to reduce weight and support advanced wireless technologies, including LIGHTSPEED wireless, the HERO 16K sensor, and POWERPLAY compatibility. The result is a G502 that " +
                    "looks and feels identical to the original but is updated in every way, while also delivering a weight reduction of 7 grams.", R.drawable.mouse1,3);
            insertItem(db, "Mouse", "HyperX Pulsefire","550TL", "The HyperX Pulsefire CoreTM is a comfortable RGB gaming mouse featuring the Pixart 3327 optical sensor for DPI settings up to 6200 and precise, smooth tracking without hardware acceleration. The ergonomically-designed mouse with symmetrical shape fits palm and claw grips and has textured sides for a no-slip grip. Gaming-grade switches output crisp tactile feedback rated for 20 million clicks. " +
                    "Customize lighting, DPI settings, and macros for 7 programmable buttons with HyperX NGenuity software.", R.drawable.mouse2,2);
            insertItem(db, "Mouse", "Razer Basilisk","670TL", "Razer Basilisk v2 Wired Gaming Mouse Chroma RGB Lighting Programmable Buttons (Renewed)\n" +
                    "\n" +
                    "Right-handed Ergonomic design Mouse\n" +
                    "Customizable Chroma RGB Color Profiles\n" +
                    "11 Programmable Buttons\n" +
                    "Five onboard memory profiles\n" +
                    "Razer Focus+ 20k DPI Optical Sensor\n" +
                    "Customizable scroll wheel resistance\n" +
                    "Razer optical mouse switch\n" +
                    "On-the-fly sensitivity adjustment through dedicated DPI buttons\n" +
                    "Wired USB Connection\n" +
                    "Razer Speedflex cable\n" +
                    "Color: Black\n" +
                    "Windows and Mac Compatibility", R.drawable.mouse3,3);
            insertItem(db, "Mouse", "ASUS Chakram","1.600TL", "The 2020 iF Design Award winning ROG Chakram is a 16,000 dpi, tri-mode wired, 2.4GHz RF and Bluetooth® LE mouse with a programmable joystick that provides superior control with your thumb. With fast charging, plus wireless Qi, pivoted buttons, detachable magnetic covers and a unique DPI On-The-Scroll feature for easy accuracy adjustment. Connect ROG Chakram any way you desire, with dual-wireless 2.4GHz and Bluetooth® LE, plus wired USB connectivity all on tap. ROG Chakram is loaded with easy DIY features, " +
                    "from its screw-less magnetic buttons and cover to exclusive push-fit switch sockets and customizable badge, providing loads of freedom to make Chakram your own.", R.drawable.mouse4,3);
            insertItem(db, "Mouse", "Razer Viper","1.720TL", "Razer Viper Ultimate With Charging Dock Wireless Optical Gaming Mouse Black\n" +
                    "\n" +
                    "\n" +
                    "True 20,000 DPI Focus+ optical sensor with 99.6% resolution accuracy\n" +
                    "Up to 650 inches per second (IPS) / 50 G acceleration\n" +
                    "Advanced Lift-off/Landing distance customization\n" +
                    "HyperSpeed wireless technology\n" +
                    "Eight independently programmable buttons\n" +
                    "Razer™ Optical Mouse Switches rated for 70M clicks\n" +
                    "True Ambidextrous shape\n" +
                    "Gaming-grade tactile scroll wheel", R.drawable.mouse5,3);
            insertItem(db, "Mouse", "Logitech G703","490TL", "Featuring a 1 ms report rate and our end-to-end optimized wireless connectivity, G703 features LIGHTSPEED wireless technology to deliver incredible responsiveness for competition-level twitch targeting. G703 comes equipped with the PMW3366 optical sensorwidely regarded by eSports professionals and gaming enthusiasts as the best gaming mouse sensor on the market. Advanced button tensioning uses metal springs to help keep the left and right mouse buttons primed to click, delivering exceptional click feel, response, and consistency. With a lightweight, ergonomically designed body, G703 was made to mold to your hand for long-lasting comfort during gameplay. Add POWERPLAY to keep G703 charged while at play and at rest.\n" +
                    "\n" +
                    "LIGHTSPEED Wireless Technology: In high-pressure moments, latency can be the difference between winning it all or losing. With millions on the line, esports professionals around the world depend on LIGHTSPEED wireless technology\n" +
                    "PMW3366 Gaming Optical Sensor: Widely regarded by esports professionals and gaming enthusiasts as the best gaming mouse sensor on the market, PMW3366 has zero smoothing, filtering, or acceleration across the entire DPI range (200-12,000DPI)", R.drawable.mouse6,2);

        }

    }






}
