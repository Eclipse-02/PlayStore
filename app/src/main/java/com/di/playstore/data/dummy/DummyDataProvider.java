package com.di.playstore.data.dummy;

import android.content.Context;

import com.di.playstore.R;
import com.di.playstore.data.model.AppModel;
import com.di.playstore.data.model.ReviewModel;
import com.di.playstore.data.model.SectionModel;
import com.di.playstore.data.model.ScreenshotModel;
import com.di.playstore.utils.PreferenceManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DummyDataProvider {

    private static List<AppModel> cache;

    public static List<AppModel> getAllApps() {
        if (cache != null) return cache;

        List<ScreenshotModel> screenshotsEndfield = new ArrayList<>();
        screenshotsEndfield.add(new ScreenshotModel("https://www.youtube.com/watch?v=Lkqb40Qzr_0"));
        screenshotsEndfield.add(new ScreenshotModel(R.drawable.ssendfield1, false));
        screenshotsEndfield.add(new ScreenshotModel(R.drawable.ssendfield2, false));
        screenshotsEndfield.add(new ScreenshotModel(R.drawable.ssendfield3, false));
        screenshotsEndfield.add(new ScreenshotModel(R.drawable.ssendfield4, false));
        screenshotsEndfield.add(new ScreenshotModel(R.drawable.ssendfield5, false));
        screenshotsEndfield.add(new ScreenshotModel(R.drawable.ssendfield6, false));

        List<ScreenshotModel> screenshotsWinds = new ArrayList<>();
        screenshotsWinds.add(new ScreenshotModel("https://www.youtube.com/watch?v=DS-J7j9kIf4"));
        screenshotsWinds.add(new ScreenshotModel(R.drawable.sswinds1, false));
        screenshotsWinds.add(new ScreenshotModel(R.drawable.sswinds2, false));
        screenshotsWinds.add(new ScreenshotModel(R.drawable.sswinds3, false));
        screenshotsWinds.add(new ScreenshotModel(R.drawable.sswinds4, false));
        screenshotsWinds.add(new ScreenshotModel(R.drawable.sswinds5, false));
        screenshotsWinds.add(new ScreenshotModel(R.drawable.sswinds6, false));
        screenshotsWinds.add(new ScreenshotModel(R.drawable.sswinds7, false));

        List<ScreenshotModel> screenshotsWarframe = new ArrayList<>();
        screenshotsWarframe.add(new ScreenshotModel("https://www.youtube.com/watch?v=tye1ROxhJEE"));
        screenshotsWarframe.add(new ScreenshotModel(R.drawable.sswarframe1, false));
        screenshotsWarframe.add(new ScreenshotModel(R.drawable.sswarframe2, false));
        screenshotsWarframe.add(new ScreenshotModel(R.drawable.sswarframe3, false));
        screenshotsWarframe.add(new ScreenshotModel(R.drawable.sswarframe4, false));
        screenshotsWarframe.add(new ScreenshotModel(R.drawable.sswarframe5, false));
        screenshotsWarframe.add(new ScreenshotModel(R.drawable.sswarframe6, false));

        List<ScreenshotModel> screenshotsGithub = new ArrayList<>();
        screenshotsGithub.add(new ScreenshotModel(R.drawable.ssgithub1, true));
        screenshotsGithub.add(new ScreenshotModel(R.drawable.ssgithub2, true));
        screenshotsGithub.add(new ScreenshotModel(R.drawable.ssgithub3, true));
        screenshotsGithub.add(new ScreenshotModel(R.drawable.ssgithub4, true));
        screenshotsGithub.add(new ScreenshotModel(R.drawable.ssgithub5, true));
        screenshotsGithub.add(new ScreenshotModel(R.drawable.ssgithub6, true));
        screenshotsGithub.add(new ScreenshotModel(R.drawable.ssgithub7, true));
        screenshotsGithub.add(new ScreenshotModel(R.drawable.ssgithub8, true));

        List<ScreenshotModel> screenshotsLinkedin = new ArrayList<>();
        screenshotsLinkedin.add(new ScreenshotModel(R.drawable.sslinkedin1, true));
        screenshotsLinkedin.add(new ScreenshotModel(R.drawable.sslinkedin2, true));
        screenshotsLinkedin.add(new ScreenshotModel(R.drawable.sslinkedin3, true));
        screenshotsLinkedin.add(new ScreenshotModel(R.drawable.sslinkedin4, true));
        screenshotsLinkedin.add(new ScreenshotModel(R.drawable.sslinkedin5, true));
        screenshotsLinkedin.add(new ScreenshotModel(R.drawable.sslinkedin6, true));

        List<ScreenshotModel> screenshotsSpotify = new ArrayList<>();
        screenshotsSpotify.add(new ScreenshotModel(R.drawable.ssspotify1, true));
        screenshotsSpotify.add(new ScreenshotModel(R.drawable.ssspotify2, true));
        screenshotsSpotify.add(new ScreenshotModel(R.drawable.ssspotify3, true));
        screenshotsSpotify.add(new ScreenshotModel(R.drawable.ssspotify4, true));
        screenshotsSpotify.add(new ScreenshotModel(R.drawable.ssspotify5, true));
        screenshotsSpotify.add(new ScreenshotModel(R.drawable.ssspotify6, true));
        screenshotsSpotify.add(new ScreenshotModel(R.drawable.ssspotify7, true));
        screenshotsSpotify.add(new ScreenshotModel(R.drawable.ssspotify8, true));

        List<ScreenshotModel> screenshotsInstagram = new ArrayList<>();
        screenshotsInstagram.add(new ScreenshotModel(R.drawable.ssinstagram1, true));
        screenshotsInstagram.add(new ScreenshotModel(R.drawable.ssinstagram2, true));
        screenshotsInstagram.add(new ScreenshotModel(R.drawable.ssinstagram3, true));
        screenshotsInstagram.add(new ScreenshotModel(R.drawable.ssinstagram4, true));
        screenshotsInstagram.add(new ScreenshotModel(R.drawable.ssinstagram5, true));
        screenshotsInstagram.add(new ScreenshotModel(R.drawable.ssinstagram6, true));
        screenshotsInstagram.add(new ScreenshotModel(R.drawable.ssinstagram7, true));

        List<ScreenshotModel> screenshotsNotion = new ArrayList<>();
        screenshotsNotion.add(new ScreenshotModel(R.drawable.ssnotion1, true));
        screenshotsNotion.add(new ScreenshotModel(R.drawable.ssnotion2, true));
        screenshotsNotion.add(new ScreenshotModel(R.drawable.ssnotion3, true));
        screenshotsNotion.add(new ScreenshotModel(R.drawable.ssnotion4, true));
        screenshotsNotion.add(new ScreenshotModel(R.drawable.ssnotion5, true));
        screenshotsNotion.add(new ScreenshotModel(R.drawable.ssnotion6, true));
        screenshotsNotion.add(new ScreenshotModel(R.drawable.ssnotion7, true));

        List<ScreenshotModel> screenshotsExpo = new ArrayList<>();
        screenshotsExpo.add(new ScreenshotModel(R.drawable.ssexpo1, true));
        screenshotsExpo.add(new ScreenshotModel(R.drawable.ssexpo2, true));
        screenshotsExpo.add(new ScreenshotModel(R.drawable.ssexpo3, true));

        List<ScreenshotModel> screenshotsDuolingo = new ArrayList<>();
        screenshotsDuolingo.add(new ScreenshotModel(R.drawable.ssduolingo1, true));
        screenshotsDuolingo.add(new ScreenshotModel(R.drawable.ssduolingo2, true));
        screenshotsDuolingo.add(new ScreenshotModel(R.drawable.ssduolingo3, true));
        screenshotsDuolingo.add(new ScreenshotModel(R.drawable.ssduolingo4, true));
        screenshotsDuolingo.add(new ScreenshotModel(R.drawable.ssduolingo5, true));
        screenshotsDuolingo.add(new ScreenshotModel(R.drawable.ssduolingo6, true));
        screenshotsDuolingo.add(new ScreenshotModel(R.drawable.ssduolingo7, true));
        screenshotsDuolingo.add(new ScreenshotModel(R.drawable.ssduolingo8, true));

        List<ScreenshotModel> screenshotsBibit = new ArrayList<>();
        screenshotsBibit.add(new ScreenshotModel(R.drawable.ssbibit1, true));
        screenshotsBibit.add(new ScreenshotModel(R.drawable.ssbibit2, true));
        screenshotsBibit.add(new ScreenshotModel(R.drawable.ssbibit3, true));
        screenshotsBibit.add(new ScreenshotModel(R.drawable.ssbibit4, true));
        screenshotsBibit.add(new ScreenshotModel(R.drawable.ssbibit5, true));
        screenshotsBibit.add(new ScreenshotModel(R.drawable.ssbibit6, true));
        screenshotsBibit.add(new ScreenshotModel(R.drawable.ssbibit7, true));

        List<ScreenshotModel> screenshotsCanva = new ArrayList<>();
        screenshotsCanva.add(new ScreenshotModel("https://www.youtube.com/watch?v=ieNU-EvLKXc"));
        screenshotsCanva.add(new ScreenshotModel(R.drawable.sscanva1, true));
        screenshotsCanva.add(new ScreenshotModel(R.drawable.sscanva2, true));
        screenshotsCanva.add(new ScreenshotModel(R.drawable.sscanva3, true));
        screenshotsCanva.add(new ScreenshotModel(R.drawable.sscanva4, true));
        screenshotsCanva.add(new ScreenshotModel(R.drawable.sscanva5, true));
        screenshotsCanva.add(new ScreenshotModel(R.drawable.sscanva6, true));
        screenshotsCanva.add(new ScreenshotModel(R.drawable.sscanva7, true));
        screenshotsCanva.add(new ScreenshotModel(R.drawable.sscanva8, true));

        List<ScreenshotModel> screenshotsDiscord = new ArrayList<>();
        screenshotsDiscord.add(new ScreenshotModel(R.drawable.ssdiscord1, true));
        screenshotsDiscord.add(new ScreenshotModel(R.drawable.ssdiscord2, true));
        screenshotsDiscord.add(new ScreenshotModel(R.drawable.ssdiscord3, true));
        screenshotsDiscord.add(new ScreenshotModel(R.drawable.ssdiscord4, true));
        screenshotsDiscord.add(new ScreenshotModel(R.drawable.ssdiscord5, true));
        screenshotsDiscord.add(new ScreenshotModel(R.drawable.ssdiscord6, true));

        List<ScreenshotModel> screenshotsSteam = new ArrayList<>();
        screenshotsSteam.add(new ScreenshotModel(R.drawable.sssteam1, true));
        screenshotsSteam.add(new ScreenshotModel(R.drawable.sssteam2, true));
        screenshotsSteam.add(new ScreenshotModel(R.drawable.sssteam3, true));
        screenshotsSteam.add(new ScreenshotModel(R.drawable.sssteam4, true));
        screenshotsSteam.add(new ScreenshotModel(R.drawable.sssteam5, true));
        screenshotsSteam.add(new ScreenshotModel(R.drawable.sssteam6, true));
        screenshotsSteam.add(new ScreenshotModel(R.drawable.sssteam7, true));

        List<ScreenshotModel> screenshotsWhatsapp = new ArrayList<>();
        screenshotsWhatsapp.add(new ScreenshotModel(R.drawable.sswhatsapp1, true));
        screenshotsWhatsapp.add(new ScreenshotModel(R.drawable.sswhatsapp2, true));
        screenshotsWhatsapp.add(new ScreenshotModel(R.drawable.sswhatsapp3, true));
        screenshotsWhatsapp.add(new ScreenshotModel(R.drawable.sswhatsapp4, true));
        screenshotsWhatsapp.add(new ScreenshotModel(R.drawable.sswhatsapp5, true));


        List<ReviewModel> reviews = Arrays.asList(
                new ReviewModel(R.drawable.user_main, 5, "Rafa", "Love it!", "15/04/2026"),
                new ReviewModel(R.drawable.user_main, 4, "Dina", "Great app", "15/04/2026")
        );

        List<String> tagsEndfield = Arrays.asList(
                "Games",
                "Action Role Playing",
                "Immersive",
                "Sci-Fi and Fantasy",
                "Anime"
        );

        List<String> tagsWinds = Arrays.asList(
                "Games",
                "Action",
                "Role Playing",
                "Action Role Playing",
                "Wuxia",
                "Immersive",
                "Stylised",
                "Widgets"
        );

        List<String> tagsWarframe = Arrays.asList(
                "Games",
                "Action"
        );

        List<String> tagsGithub = Arrays.asList(
                "Productivity",
                "Tools",
                "Widgets"
        );

        List<String> tagsLinkedin = Arrays.asList(
                "Business",
                "Networking",
                "Employment Resource and Tools",
                "Widgets"
        );

        List<String> tagsSpotify = Arrays.asList(
                "Music",
                "Podcast",
                "Streaming",
                "Widgets"
        );

        List<String> tagsInstagram = Arrays.asList(
                "Social",
                "Networking",
                "Widgets"
        );

        List<String> tagsNotion = Arrays.asList(
                "Productivity",
                "Notes",
                "Widgets"
        );

        List<String> tagsExpo = List.of(
                "Libraries & Demo"
        );

        List<String> tagsDuolingo = Arrays.asList(
                "Education",
                "Widgets"
        );

        List<String> tagsBibit = Arrays.asList(
                "Finance",
                "Fund"
        );

        List<String> tagsCanva = Arrays.asList(
                "Design",
                "Photography",
                "Photo Editor",
                "Graphic Design"
        );

        List<String> tagsDiscord = Arrays.asList(
                "Communication",
                "Social",
                "Messaging"
        );

        List<String> tagsSteam = Arrays.asList(
                "Entertainment",
                "Multi-Platform Gaming"
        );

        List<String> tagsWhatsapp = Arrays.asList(
                "Communication",
                "Messaging",
                "Widgets"
        );

        cache = new ArrayList<>();
        cache.add(new AppModel("Arknights: Endfield", "GRYPHLINE", "3D real-time strategy RPG developed by HYPERGRYPH", "4.1", "653 MB", "1m+", R.drawable.appendfield, R.drawable.ssendfield1, screenshotsEndfield, reviews, tagsEndfield));
        cache.add(new AppModel("Where Winds Meet", "Exptional Global", "Wuxia Opwn World ARPG", "4.3", "3.4 GB", "1m+", R.drawable.appwinds, R.drawable.sswinds1, screenshotsWinds, reviews, tagsWinds));
        cache.add(new AppModel("Warframe", "Digital Extremes", "Battle alongside your friends in this story-driven, online action game", "4.2", "3.7 GB", "1m+", R.drawable.appwarframe, R.drawable.sswarframe1, screenshotsWarframe, reviews, tagsWarframe));
        cache.add(new AppModel("GitHub", "GitHub", "Triage notification, review, comment, and merge, right from your mobile device", "4.9", "88 MB", "10m+", R.drawable.appgithub, R.drawable.ssgithub1, screenshotsGithub, reviews, tagsGithub));
        cache.add(new AppModel("LinkedIn", "LinkedIn", "Smarter career moves start here. AI job alerts, insights & the right tools", "4.0", "72 MB", "1bn+", R.drawable.applinkedin, R.drawable.sslinkedin1, screenshotsLinkedin, reviews, tagsLinkedin));
        cache.add(new AppModel("Spotify", "Spotify AB", "Listen to songs, play podcast, create playlist and discover music you'll love", "4.3", "85 MB", "1bn+", R.drawable.appspotify, R.drawable.ssspotify1, screenshotsSpotify, reviews, tagsSpotify));
        cache.add(new AppModel("Instagram", "Instagram", "Create & share photos, stories, & reels with friends you love", "4.2", "92 MB", "5bn+", R.drawable.appinstagram, R.drawable.ssinstagram1, screenshotsInstagram, reviews, tagsInstagram));
        cache.add(new AppModel("Notion", "Notion Labs, Inc.", "Write notes, plan projects and organise tasks easily in one connected workspace", "4.8", "76 MB", "10m+", R.drawable.appnotion, R.drawable.ssnotion1, screenshotsNotion, reviews, tagsNotion));
        cache.add(new AppModel("Expo Go", "Expo Project", "Expo is a free & open source platform to build apps using JavaScript and React", "4.9", "30 MB", "1m+", R.drawable.appexpo, R.drawable.ssexpo1, screenshotsExpo, reviews, tagsExpo));
        cache.add(new AppModel("Duolingo", "Duolingo", "Learn Spanish, French, German, English, Math, Music and more for free", "4.8", "55 MB", "500m+", R.drawable.appduolingo, R.drawable.ssduolingo1, screenshotsDuolingo, reviews, tagsDuolingo));
        cache.add(new AppModel("Bibit", "PT. Bibit Tumbuh Bersama", "Investasi di Reksadana, SBN, Obligasi FR dan Saham untuk Investor Casual", "4.8", "155 MB", "10m+", R.drawable.appbibit, R.drawable.ssbibit1, screenshotsBibit, reviews, tagsBibit));
        cache.add(new AppModel("Canva", "Canva", "Canva makes it easy to create professional designs powered by AI", "4.8", "17 MB", "500m+", R.drawable.appcanva, R.drawable.sscanva1, screenshotsCanva, reviews, tagsCanva));
        cache.add(new AppModel("Discord", "Discord Inc.", "Group Chat That's Fun & Games", "4.3", "66 MB", "500m+", R.drawable.appdiscord, R.drawable.ssdiscord1, screenshotsDiscord, reviews, tagsDiscord));
        cache.add(new AppModel("Steam", "Valve Corporation", "With Steam Mobile App, you can take Steam with you anywhere", "2.5", "231 MB", "100m+", R.drawable.appsteam, R.drawable.sssteam1, screenshotsSteam, reviews, tagsSteam));
        cache.add(new AppModel("WhatsApp", "WhatsApp LLC", "Simple. Reliable. Private.", "4.6", "182 MB", "10bn+", R.drawable.appwhatsapp, R.drawable.sswhatsapp1, screenshotsWhatsapp, reviews, tagsWhatsapp));

        return cache;
    }

    public static List<SectionModel> getAppSections() {
        List<AppModel> allApps = getAllApps();
        List<SectionModel> sections = new ArrayList<>();

        if (allApps.size() < 6) return sections;

        List<AppModel> featured = new ArrayList<>(allApps.subList(0, 3));
        List<AppModel> recommended = new ArrayList<>(allApps.subList(3, 9));
        List<AppModel> suggested = new ArrayList<>(allApps.subList(9, 15));

        sections.add(new SectionModel("Featured", 0, featured));
        sections.add(new SectionModel("Recommended for you", 1, recommended));
        sections.add(new SectionModel("Suggested for you", 2, suggested));

        return sections;
    }

    public static List<AppModel> getWishlistApps(Context context) {
        List<AppModel> allApps = getAllApps();
        List<AppModel> result = new ArrayList<>();

        for (AppModel app : allApps) {
            if (PreferenceManager.isWishlisted(context, app.getName())) {
                result.add(app);
            }
        }

        return result;
    }

    public static List<AppModel> getInstalledApps(Context context) {
        List<AppModel> allApps = getAllApps();
        List<AppModel> result = new ArrayList<>();

        for (AppModel app : allApps) {
            if (PreferenceManager.isInstalled(context, app.getName())) {
                result.add(app);
            }
        }

        return result;
    }
}