package com.legalawareness.india.data

import java.util.Locale

/** Bundled awareness material. Reading and searching never require an internet connection. */
object LegalContent {
    val disclaimer = text(
        "General legal awareness, not legal advice. Rules, procedures and available services may change and differ by state. Check the official sources and consult a qualified lawyer about your circumstances. Telugu text is an explanatory translation, not an official legal translation.",
        "ఇది సాధారణ న్యాయ అవగాహన సమాచారం మాత్రమే; వ్యక్తిగత న్యాయ సలహా కాదు. నియమాలు, విధానాలు, సేవలు మారవచ్చు; రాష్ట్రాన్ని బట్టి భిన్నంగా ఉండవచ్చు. అధికారిక వనరులను పరిశీలించి, మీ పరిస్థితికి తగిన సలహా కోసం అర్హత గల న్యాయవాదిని సంప్రదించండి. తెలుగు సమాచారం వివరణాత్మక అనువాదం మాత్రమే; అధికారిక చట్ట అనువాదం కాదు.",
    )

    val categories: List<LegalCategory> = listOf(
        LegalCategory("rights", text("Your rights", "మీ హక్కులు"), text("Police procedures and access to legal help", "పోలీసు విధానాలు, న్యాయ సహాయం")),
        LegalCategory("consumer", text("Consumer protection", "వినియోగదారుల రక్షణ"), text("Purchases, services and banking complaints", "కొనుగోళ్లు, సేవలు, బ్యాంకు ఫిర్యాదులు")),
        LegalCategory("cyber", text("Digital safety", "డిజిటల్ భద్రత"), text("Online fraud, privacy and reporting", "ఆన్‌లైన్ మోసాలు, గోప్యత, ఫిర్యాదులు")),
        LegalCategory("family", text("Family & safety", "కుటుంబం, భద్రత"), text("Domestic violence and child protection", "గృహ హింస, బాలల రక్షణ")),
        LegalCategory("workplace", text("At work", "పని ప్రదేశంలో"), text("Pay records and a safer workplace", "వేతన రికార్డులు, సురక్షిత పని ప్రదేశం")),
        LegalCategory("services", text("Public services", "ప్రభుత్వ సేవలు"), text("Information requests and public grievances", "సమాచార అభ్యర్థనలు, ప్రజా ఫిర్యాదులు")),
    )

    val articles: List<LegalArticle> = listOf(
        LegalArticle(
            id = "police-complaints-and-rights",
            categoryId = "rights",
            title = text("At a police station: complaints & rights", "పోలీసు స్టేషన్‌లో: ఫిర్యాదులు, హక్కులు"),
            summary = text("Understand how to report an offence, keep a record and ask for legal help.", "నేరంపై ఎలా ఫిర్యాదు చేయాలో, రికార్డులు ఎలా భద్రపరచాలో, న్యాయ సహాయం ఎలా కోరాలో తెలుసుకోండి."),
            readingMinutes = 4,
            sections = listOf(
                section("Make a clear complaint", "స్పష్టంగా ఫిర్యాదు చేయండి",
                    "Write what happened, when and where it happened, and any witnesses. Keep copies of messages, receipts and other evidence. Under the BNSS, information about a cognizable offence can be given to a police station irrespective of where the offence occurred. Ask for an acknowledgement and, where an FIR is registered, the free copy available to the informant or victim. Not every complaint is an FIR; the procedure depends on the alleged offence.",
                    "ఏం జరిగింది, ఎప్పుడు, ఎక్కడ జరిగింది, సాక్షులు ఎవరు అన్న వివరాలను రాయండి. సందేశాలు, రసీదులు, ఇతర ఆధారాల ప్రతులను భద్రపరచండి. BNSS ప్రకారం, పోలీసులు నేరుగా దర్యాప్తు చేయగల నేరం గురించి అది జరిగిన ప్రాంతంతో సంబంధం లేకుండా పోలీసు స్టేషన్‌కు సమాచారం ఇవ్వవచ్చు. ఫిర్యాదు స్వీకరణ రుజువు కోరండి. FIR నమోదైతే, సమాచారం ఇచ్చిన వ్యక్తి లేదా బాధితుడికి లభించే ఉచిత ప్రతిని అడగండి. ప్రతి ఫిర్యాదు FIR కాదు; ఆరోపించిన నేరాన్ని బట్టి విధానం మారుతుంది."),
                section("If you are arrested", "అరెస్టు అయితే",
                    "Safeguards include being informed of the grounds of arrest, access to legal representation, and production before a magistrate within the applicable legal time limit. Ask that a relative or friend be informed, and request medical attention when needed. Do not sign a document you do not understand; ask for an explanation and legal help. Specific rules and exceptions depend on the case.",
                    "అరెస్టు కారణాలు తెలియజేయడం, న్యాయవాది సహాయం పొందడం, చట్టం నిర్దేశించిన గడువులో మేజిస్ట్రేట్ ముందు హాజరుపరచడం వంటి రక్షణలు ఉన్నాయి. బంధువు లేదా స్నేహితుడికి సమాచారం ఇవ్వమని అడగండి; అవసరమైతే వైద్య సహాయం కోరండి. అర్థం కాని పత్రంపై సంతకం చేసే ముందు వివరణ, న్యాయ సహాయం కోరండి. ప్రత్యేక నియమాలు, మినహాయింపులు కేసును బట్టి ఉంటాయి."),
                section("Which criminal law applies?", "ఏ క్రిమినల్ చట్టం వర్తిస్తుంది?",
                    "The Bharatiya Nyaya Sanhita (BNS) and Bharatiya Nagarik Suraksha Sanhita (BNSS) generally came into force on 1 July 2024, subject to notified exceptions. Older events or proceedings may involve earlier laws and transition provisions. A lawyer can identify the applicable law. For immediate danger, call 112; for legal-aid guidance, contact NALSA or your District Legal Services Authority.",
                    "భారతీయ న్యాయ సంహిత (BNS), భారతీయ నాగరిక సురక్షా సంహిత (BNSS) నోటిఫై చేసిన మినహాయింపులకు లోబడి సాధారణంగా 1 జూలై 2024 నుంచి అమల్లోకి వచ్చాయి. పాత సంఘటనలు లేదా విచారణలకు పూర్వ చట్టాలు, మార్పు నిబంధనలు వర్తించవచ్చు. వర్తించే చట్టాన్ని న్యాయవాది గుర్తించగలరు. తక్షణ ప్రమాదంలో 112కు కాల్ చేయండి. న్యాయ సహాయం కోసం NALSA లేదా జిల్లా న్యాయ సేవాధికార సంస్థను సంప్రదించండి."),
            ),
            sources = listOf(
                LegalSource("India Code — Bharatiya Nagarik Suraksha Sanhita, 2023", "https://www.indiacode.nic.in/indiacode/handle/123456789/20099?view_type=browse"),
                LegalSource("India Code — Bharatiya Nyaya Sanhita, 2023", "https://www.indiacode.nic.in/indiacode/handle/123456789/20062?view_type=browse"),
                LegalSource("Emergency Response Support System — 112", "https://112.gov.in/"),
                LegalSource("National Legal Services Authority", "https://nalsa.gov.in/"),
            ),
        ),
        LegalArticle(
            id = "free-legal-aid",
            categoryId = "rights",
            title = text("Finding free legal aid", "ఉచిత న్యాయ సహాయం పొందడం"),
            summary = text("Find out where to ask about eligibility, legal advice and representation.", "అర్హత, న్యాయ సలహా, న్యాయవాది సహాయం గురించి ఎక్కడ అడగాలో తెలుసుకోండి."),
            readingMinutes = 3,
            sections = listOf(
                section("Who may be eligible?", "ఎవరికి అర్హత ఉండవచ్చు?",
                    "The Legal Services Authorities Act provides eligibility categories including women, children, members of Scheduled Castes or Scheduled Tribes, persons in custody and certain other groups. Income-based eligibility also exists; applicable limits vary. Free legal services are subject to the statutory criteria and assessment by the relevant authority. Ask the authority to assess your circumstances instead of assuming you are ineligible.",
                    "న్యాయ సేవాధికార సంస్థల చట్టంలో మహిళలు, పిల్లలు, షెడ్యూల్డ్ కులాలు లేదా తెగల సభ్యులు, నిర్బంధంలో ఉన్నవారు, మరికొన్ని వర్గాలకు అర్హత నిబంధనలు ఉన్నాయి. ఆదాయం ఆధారంగా కూడా అర్హత ఉండవచ్చు; పరిమితులు మారుతాయి. సంబంధిత సంస్థ చట్టపరమైన ప్రమాణాల ప్రకారం అర్హతను పరిశీలిస్తుంది. మీకు అర్హత లేదని ఊహించకుండా, మీ పరిస్థితిని పరిశీలించమని సంస్థను కోరండి."),
                section("Where to begin", "ఎక్కడ ప్రారంభించాలి",
                    "Contact the District Legal Services Authority (DLSA), usually located at the district court, or the State Legal Services Authority. NALSA's legal-aid helpline is 15100. Explain your problem and ask about the application process, required documents and language assistance. Legal aid may cover advice, drafting or representation as appropriate; it does not guarantee a particular case outcome.",
                    "సాధారణంగా జిల్లా కోర్టులో ఉండే జిల్లా న్యాయ సేవాధికార సంస్థ (DLSA) లేదా రాష్ట్ర న్యాయ సేవాధికార సంస్థను సంప్రదించండి. NALSA న్యాయ సహాయ హెల్ప్‌లైన్ 15100. మీ సమస్యను వివరించి, దరఖాస్తు విధానం, అవసరమైన పత్రాలు, భాషా సహాయం గురించి అడగండి. అవసరాన్ని బట్టి సలహా, పత్రాల తయారీ లేదా న్యాయవాది సహాయం లభించవచ్చు. కేసు ఫలితానికి హామీ ఉండదు."),
                section("Prepare for your visit", "సంప్రదించడానికి సిద్ధం కావడం",
                    "Bring available identity documents, notices, orders, key messages and a short timeline. Ask which eligibility evidence is needed. Keep copies and note any hearing or appeal deadline. If a deadline is close, explain that immediately. Lok Adalat can help settle suitable disputes, but settlement and jurisdiction rules must be considered with the authority or your lawyer.",
                    "అందుబాటులో ఉన్న గుర్తింపు పత్రాలు, నోటీసులు, ఉత్తర్వులు, ముఖ్య సందేశాలు, సంఘటనల సంక్షిప్త క్రమాన్ని తీసుకెళ్లండి. అర్హతకు ఏ ఆధారాలు అవసరమో అడగండి. ప్రతులను భద్రపరచి, విచారణ లేదా అప్పీల్ గడువులను గుర్తించండి. గడువు దగ్గరగా ఉంటే వెంటనే చెప్పండి. తగిన వివాదాల పరిష్కారానికి లోక్ అదాలత్ ఉపయోగపడవచ్చు; వర్తించే పరిధి, రాజీ నియమాల గురించి సంస్థ లేదా న్యాయవాదిని అడగండి."),
            ),
            sources = listOf(
                LegalSource("NALSA — legal aid eligibility and applications", "https://nalsa.gov.in/legal-aid/"),
                LegalSource("NALSA — FAQs and helpline 15100", "https://nalsa.gov.in/faqs/"),
                LegalSource("NALSA — Legal Services Authorities Act, 1987", "https://nalsa.gov.in/the-legal-services-authorities-act-1987/"),
            ),
        ),
        LegalArticle(
            id = "consumer-complaints",
            categoryId = "consumer",
            title = text("A problem with a purchase or service?", "కొనుగోలు లేదా సేవలో సమస్య ఉందా?"),
            summary = text("Keep evidence, raise a written complaint and understand consumer redress options.", "ఆధారాలు భద్రపరచి, రాతపూర్వకంగా ఫిర్యాదు చేసి, పరిష్కార మార్గాలను తెలుసుకోండి."),
            readingMinutes = 3,
            sections = listOf(
                section("Save the details", "వివరాలను భద్రపరచండి",
                    "Keep the invoice, order number, payment proof, warranty, advertisement and photographs of the problem. Write to the seller or service provider with the facts and the remedy you seek, such as repair, replacement or refund. Save the complaint number and replies. Eligibility and remedies depend on the facts, applicable law and contract; there is no universal right to return every purchase simply because you changed your mind.",
                    "బిల్లు, ఆర్డర్ నంబర్, చెల్లింపు రుజువు, వారంటీ, ప్రకటన, సమస్యకు సంబంధించిన ఫొటోలను భద్రపరచండి. జరిగిన విషయాలు, మీరు కోరే మరమ్మతు, మార్పిడి లేదా రీఫండ్ గురించి విక్రేతకు లేదా సేవా సంస్థకు రాయండి. ఫిర్యాదు నంబర్, సమాధానాలను దాచండి. అర్హత, పరిష్కారం పరిస్థితులు, చట్టం, ఒప్పందంపై ఆధారపడతాయి. మనసు మార్చుకున్నంత మాత్రాన ప్రతి కొనుగోలును తిరిగి ఇచ్చే సాధారణ హక్కు ఉండదు."),
                section("Use consumer support", "వినియోగదారుల సహాయం పొందండి",
                    "The National Consumer Helpline offers pre-litigation grievance support through its official portal and 1915. Submit clear facts and relevant documents. This support can help raise a grievance but is not a court order and cannot promise a refund. Never share an OTP or pay a supposed refund-processing charge to someone who contacts you unexpectedly.",
                    "జాతీయ వినియోగదారుల హెల్ప్‌లైన్ అధికారిక పోర్టల్, 1915 ద్వారా కోర్టుకు వెళ్లే ముందు ఫిర్యాదులపై సహాయం అందిస్తుంది. స్పష్టమైన వివరాలు, సంబంధిత పత్రాలను సమర్పించండి. ఈ సహాయం ఫిర్యాదును ముందుకు తీసుకెళ్లవచ్చు; ఇది కోర్టు ఉత్తర్వు కాదు, రీఫండ్‌కు హామీ కాదు. అనుకోకుండా సంప్రదించిన వ్యక్తికి OTP చెప్పకండి; రీఫండ్ ప్రాసెసింగ్ పేరుతో రుసుము చెల్లించకండి."),
                section("Consider formal redress", "అధికారిక పరిష్కారాన్ని పరిశీలించండి",
                    "Consumer commissions can hear eligible consumer disputes under the Consumer Protection Act. Jurisdiction, limitation periods, fees and evidence requirements matter. Complaints normally have a two-year limitation from the cause of action, with possible condonation of delay for sufficient cause. Seek advice on your dates and circumstances, and use the official Department of Consumer Affairs website to find the current filing route.",
                    "వినియోగదారుల పరిరక్షణ చట్టం ప్రకారం అర్హమైన వివాదాలను వినియోగదారుల కమిషన్లు విచారించవచ్చు. పరిధి, గడువులు, రుసుములు, ఆధారాల నియమాలు ముఖ్యం. సాధారణంగా సమస్యకు కారణమైన సంఘటన నుంచి రెండు సంవత్సరాల గడువు ఉంటుంది; తగిన కారణంతో ఆలస్యాన్ని క్షమించే అవకాశం ఉండవచ్చు. మీ తేదీలు, పరిస్థితులపై సలహా తీసుకొని, ప్రస్తుత దాఖలు విధానం కోసం వినియోగదారుల వ్యవహారాల శాఖ అధికారిక వెబ్‌సైట్‌ను చూడండి."),
            ),
            sources = listOf(
                LegalSource("National Consumer Helpline — grievance support", "https://consumerhelpline.gov.in/public/index.php/about"),
                LegalSource("Department of Consumer Affairs", "https://consumeraffairs.nic.in/"),
                LegalSource("India Code — Consumer Protection Act, 2019", "https://www.indiacode.nic.in/indiacode/handle/123456789/21423?view_type=browse"),
            ),
        ),
        LegalArticle(
            id = "banking-grievances",
            categoryId = "consumer",
            title = text("Banking complaints & disputed transactions", "బ్యాంకు ఫిర్యాదులు, వివాదాస్పద లావాదేవీలు"),
            summary = text("Report a banking issue promptly and know when the RBI complaint route may apply.", "బ్యాంకు సమస్యను త్వరగా తెలియజేసి, RBI ఫిర్యాదు మార్గం ఎప్పుడు వర్తించవచ్చో తెలుసుకోండి."),
            readingMinutes = 3,
            sections = listOf(
                section("Contact the provider first", "ముందుగా సేవా సంస్థను సంప్రదించండి",
                    "For an unfamiliar debit, failed transfer, unexpected charge or service problem, use the bank's official app, website or published phone number. Report unauthorised transactions immediately and ask how to block the affected payment method. Keep the transaction reference and complaint acknowledgement. Liability or reimbursement depends on the applicable RBI rules, reporting time and facts; a refund is not automatic.",
                    "తెలియని డెబిట్, విఫలమైన బదిలీ, అనుకోని రుసుము లేదా సేవా సమస్య కోసం బ్యాంకు అధికారిక యాప్, వెబ్‌సైట్ లేదా ప్రకటించిన ఫోన్ నంబర్‌ను ఉపయోగించండి. అనుమతి లేని లావాదేవీని వెంటనే తెలియజేసి, సంబంధిత చెల్లింపు సాధనాన్ని ఎలా నిలిపివేయాలో అడగండి. లావాదేవీ రిఫరెన్స్, ఫిర్యాదు స్వీకరణ రుజువును భద్రపరచండి. బాధ్యత, రీఫండ్ వర్తించే RBI నియమాలు, ఫిర్యాదు చేసిన సమయం, పరిస్థితులపై ఆధారపడతాయి; రీఫండ్ స్వయంచాలకంగా రాదు."),
                section("Escalating to RBI", "RBIకి ఫిర్యాదు చేయడం",
                    "For complaints covered by the RBI Integrated Ombudsman Scheme, first complain to the regulated entity in writing. If its response is unsatisfactory, or it does not respond within the applicable period, the RBI Complaint Management System may be available. The period is generally 30 days, or a longer period specified by relevant payment-system rules. Coverage, time limits and admissibility conditions apply. Check the current scheme and keep proof of the first complaint. Filing with RBI is free.",
                    "RBI సమీకృత అంబుడ్స్‌మన్ పథకం పరిధిలోని ఫిర్యాదులకు ముందుగా సంబంధిత నియంత్రిత సంస్థకు రాతపూర్వకంగా ఫిర్యాదు చేయాలి. సమాధానం సంతృప్తికరంగా లేకపోతే లేదా వర్తించే గడువులో సమాధానం రాకపోతే RBI ఫిర్యాదు నిర్వహణ వ్యవస్థను ఉపయోగించవచ్చు. సాధారణంగా 30 రోజులు లేదా సంబంధిత చెల్లింపు వ్యవస్థ నియమాల్లో ఉన్న ఎక్కువ గడువు వర్తిస్తుంది. పరిధి, గడువులు, స్వీకరణ నిబంధనలు వర్తిస్తాయి. ప్రస్తుత పథకాన్ని పరిశీలించి, మొదటి ఫిర్యాదు రుజువును దాచండి. RBI వద్ద ఫిర్యాదు దాఖలు ఉచితం."),
                section("If fraud is suspected", "మోసం అనుమానిస్తే",
                    "For financial cyber fraud, also call 1930 promptly and report through the National Cyber Crime Reporting Portal. Report to your bank immediately; one report does not replace the other. Preserve payment references and suspicious messages. Officials do not need your OTP, PIN or password to register a complaint.",
                    "ఆర్థిక సైబర్ మోసం అయితే వెంటనే 1930కు కాల్ చేసి, జాతీయ సైబర్ నేరాల ఫిర్యాదు పోర్టల్‌లో కూడా తెలియజేయండి. బ్యాంకుకు తక్షణమే ఫిర్యాదు చేయండి; ఒక ఫిర్యాదు మరొకదానికి ప్రత్యామ్నాయం కాదు. చెల్లింపు రిఫరెన్స్‌లు, అనుమానాస్పద సందేశాలను భద్రపరచండి. ఫిర్యాదు నమోదు చేయడానికి అధికారులకు మీ OTP, PIN లేదా పాస్‌వర్డ్ అవసరం లేదు."),
            ),
            sources = listOf(
                LegalSource("RBI Complaint Management System", "https://cms.rbi.org.in/"),
                LegalSource("Reserve Bank of India — Integrated Ombudsman Scheme FAQs", "https://old.rbi.org.in/commonman/english/scripts/faqs.aspx?id=3407"),
                LegalSource("National Cyber Crime Reporting Portal", "https://cybercrime.gov.in/"),
            ),
        ),
        LegalArticle(
            id = "financial-cyber-fraud",
            categoryId = "cyber",
            title = text("Act quickly after financial cyber fraud", "ఆర్థిక సైబర్ మోసం జరిగితే వెంటనే స్పందించండి"),
            summary = text("A practical response to payment scams, account theft and fraudulent transfers.", "చెల్లింపు మోసాలు, ఖాతా దొంగతనం, మోసపూరిత బదిలీలకు ఆచరణాత్మక చర్యలు."),
            readingMinutes = 3,
            sections = listOf(
                section("Report promptly", "త్వరగా ఫిర్యాదు చేయండి",
                    "If money has been taken through a cyber scam, contact your bank or payment provider immediately, call 1930, and use cybercrime.gov.in to report the incident. Follow the acknowledgement instructions to complete the complaint. Fast reporting may help authorities attempt to stop funds from moving, but it does not guarantee recovery. In immediate physical danger, call 112.",
                    "సైబర్ మోసం ద్వారా డబ్బు పోయినట్లయితే వెంటనే బ్యాంకు లేదా చెల్లింపు సంస్థను సంప్రదించి, 1930కు కాల్ చేసి, cybercrime.gov.inలో ఫిర్యాదు చేయండి. ఫిర్యాదును పూర్తి చేయడానికి స్వీకరణ సందేశంలోని సూచనలను పాటించండి. త్వరగా తెలియజేయడం వల్ల డబ్బు బదిలీని ఆపే ప్రయత్నాలకు సహాయపడవచ్చు; డబ్బు తిరిగి వస్తుందని హామీ లేదు. తక్షణ శారీరక ప్రమాదంలో 112కు కాల్ చేయండి."),
                section("Keep useful evidence", "ఉపయోగకరమైన ఆధారాలను దాచండి",
                    "Save the transaction ID, amount, date, account or payment details, phone numbers, website addresses and screenshots. Preserve the original messages and emails if possible. Do not delete the chat in panic or send more money to recover the first payment. Share sensitive evidence through official reporting channels, not public social-media posts.",
                    "లావాదేవీ ID, మొత్తం, తేదీ, ఖాతా లేదా చెల్లింపు వివరాలు, ఫోన్ నంబర్లు, వెబ్‌సైట్ చిరునామాలు, స్క్రీన్‌షాట్లను భద్రపరచండి. వీలైతే అసలు సందేశాలు, ఇమెయిళ్లు దాచండి. భయంతో చాట్‌ను తొలగించకండి; మొదటి చెల్లింపును తిరిగి పొందడానికి మరింత డబ్బు పంపకండి. సున్నితమైన ఆధారాలను అధికారిక ఫిర్యాదు మార్గాల్లో సమర్పించండి; బహిరంగ సోషల్ మీడియా పోస్టుల్లో పెట్టకండి."),
                section("Secure your accounts", "మీ ఖాతాలను రక్షించండి",
                    "Using a trusted device, change compromised passwords and review signed-in devices. Ask the bank about blocking affected cards or accounts. Never share an OTP, UPI PIN or screen-control access with a stranger. A UPI PIN authorises a payment; you do not enter it just to receive money. Be suspicious of people claiming a 'digital arrest' and demanding payment; verify through official police channels.",
                    "నమ్మకమైన పరికరం నుంచి బయటపడిన పాస్‌వర్డ్‌లను మార్చి, ఖాతాలో లాగిన్ అయిన పరికరాలను పరిశీలించండి. సంబంధిత కార్డులు లేదా ఖాతాలను నిలిపివేయడం గురించి బ్యాంకును అడగండి. అపరిచితులకు OTP, UPI PIN లేదా స్క్రీన్ నియంత్రణ ఇవ్వకండి. UPI PIN చెల్లింపును అనుమతిస్తుంది; డబ్బు అందుకోవడానికి మాత్రమే దాన్ని నమోదు చేయాల్సిన అవసరం లేదు. 'డిజిటల్ అరెస్ట్' పేరుతో డబ్బు అడిగేవారిని నమ్మకండి; అధికారిక పోలీసు మార్గాల్లో నిర్ధారించండి."),
            ),
            sources = listOf(
                LegalSource("National Cyber Crime Reporting Portal — 1930", "https://cybercrime.gov.in/"),
                LegalSource("Indian Cyber Crime Coordination Centre", "https://i4c.mha.gov.in/"),
                LegalSource("National Payments Corporation of India — UPI safety", "https://www.npci.org.in/"),
            ),
        ),
        LegalArticle(
            id = "online-safety-and-harassment",
            categoryId = "cyber",
            title = text("Online harassment, impersonation & privacy", "ఆన్‌లైన్ వేధింపులు, నకిలీ ఖాతాలు, గోప్యత"),
            summary = text("Preserve evidence, use reporting tools and protect your personal information.", "ఆధారాలను భద్రపరచి, ఫిర్యాదు సాధనాలను ఉపయోగించి, వ్యక్తిగత సమాచారాన్ని రక్షించుకోండి."),
            readingMinutes = 3,
            sections = listOf(
                section("Document the behaviour", "జరిగిన విషయాలను నమోదు చేయండి",
                    "Record the account name, profile link, dates and threatening or abusive messages before blocking, if safe. Report impersonation, stalking, threats or unauthorised intimate content to the platform and, where appropriate, the police or National Cyber Crime Reporting Portal. Avoid responding to threats with threats. If you face immediate danger, contact 112.",
                    "సురక్షితమైతే బ్లాక్ చేసే ముందు ఖాతా పేరు, ప్రొఫైల్ లింక్, తేదీలు, బెదిరింపు లేదా దూషణ సందేశాలను నమోదు చేయండి. నకిలీ ఖాతాలు, వెంటాడడం, బెదిరింపులు లేదా అనుమతి లేని వ్యక్తిగత చిత్రాల గురించి ప్లాట్‌ఫామ్‌కు, అవసరాన్ని బట్టి పోలీసులకు లేదా జాతీయ సైబర్ నేరాల ఫిర్యాదు పోర్టల్‌కు తెలియజేయండి. బెదిరింపులకు ప్రతిగా బెదిరించకండి. తక్షణ ప్రమాదంలో 112ను సంప్రదించండి."),
                section("Limit further exposure", "మరింత వ్యాప్తిని తగ్గించండి",
                    "Review who can view your profile, location, contact details and posts. Enable two-step verification and check recovery settings. Report harmful content through the platform's official process. Do not repost intimate images or child sexual abuse material to prove a complaint; record relevant links and seek instructions from police on preserving evidence safely.",
                    "మీ ప్రొఫైల్, స్థానం, సంప్రదింపు వివరాలు, పోస్టులను ఎవరు చూడగలరో పరిశీలించండి. రెండు దశల ధృవీకరణను అమలు చేసి, ఖాతా పునరుద్ధరణ సెట్టింగులను తనిఖీ చేయండి. హానికరమైన కంటెంట్‌పై ప్లాట్‌ఫామ్ అధికారిక విధానంలో ఫిర్యాదు చేయండి. ఫిర్యాదు రుజువుగా వ్యక్తిగత చిత్రాలను లేదా బాలల లైంగిక దుర్వినియోగ కంటెంట్‌ను మళ్లీ పోస్టు చేయకండి; సంబంధిత లింకులను నమోదు చేసి, ఆధారాలను సురక్షితంగా భద్రపరచడంపై పోలీసుల సూచనలు తీసుకోండి."),
                section("Find support", "సహాయం పొందండి",
                    "Tell someone you trust, especially if you are being blackmailed or feel unsafe. The cybercrime portal has reporting routes for different types of cyber crime; read the relevant instructions. Some offences and complaint options depend on age, consent and the type of content. A legal-aid authority or lawyer can explain the appropriate route for your situation.",
                    "బ్లాక్‌మెయిల్ ఎదురైనా లేదా భద్రతపై భయం ఉన్నా నమ్మకమైన వ్యక్తికి చెప్పండి. సైబర్ నేరాల పోర్టల్‌లో వివిధ నేరాలకు ఫిర్యాదు మార్గాలు ఉన్నాయి; సంబంధిత సూచనలను చదవండి. కొన్ని నేరాలు, ఫిర్యాదు అవకాశాలు వయస్సు, సమ్మతి, కంటెంట్ స్వభావంపై ఆధారపడతాయి. మీ పరిస్థితికి తగిన మార్గాన్ని న్యాయ సహాయ సంస్థ లేదా న్యాయవాది వివరించగలరు."),
            ),
            sources = listOf(
                LegalSource("National Cyber Crime Reporting Portal", "https://cybercrime.gov.in/"),
                LegalSource("Indian Cyber Crime Coordination Centre — cyber awareness", "https://i4c.mha.gov.in/"),
                LegalSource("India Code — applicable criminal and information technology laws", "https://www.indiacode.nic.in/"),
            ),
        ),
        LegalArticle(
            id = "domestic-violence-support",
            categoryId = "family",
            title = text("Domestic violence: safety & support", "గృహ హింస: భద్రత, సహాయం"),
            summary = text("Recognise abuse and learn about protection, assistance and legal options.", "హింసను గుర్తించి, రక్షణ, సహాయం, న్యాయ మార్గాల గురించి తెలుసుకోండి."),
            readingMinutes = 4,
            sections = listOf(
                section("Prioritise immediate safety", "తక్షణ భద్రతకు ప్రాధాన్యం ఇవ్వండి",
                    "If there is immediate danger, call 112 or seek a safe place and medical help. If safe, tell a trusted person and keep essential documents, medicines and emergency contacts accessible. A One Stop Centre or district women and child development office can help you find available support. Do not confront an abuser just to collect evidence.",
                    "తక్షణ ప్రమాదం ఉంటే 112కు కాల్ చేయండి లేదా సురక్షిత ప్రదేశానికి వెళ్లి వైద్య సహాయం పొందండి. సురక్షితమైతే నమ్మకమైన వ్యక్తికి చెప్పి, అవసరమైన పత్రాలు, మందులు, అత్యవసర సంప్రదింపులను అందుబాటులో ఉంచండి. వన్ స్టాప్ సెంటర్ లేదా జిల్లా మహిళా, శిశు అభివృద్ధి కార్యాలయం అందుబాటులో ఉన్న సహాయం గురించి తెలియజేయగలదు. ఆధారాలు సేకరించడానికి మాత్రమే హింసించే వ్యక్తిని ఎదుర్కొనకండి."),
                section("Understand available protection", "అందుబాటులో ఉన్న రక్షణను తెలుసుకోండి",
                    "The Protection of Women from Domestic Violence Act addresses physical, sexual, verbal, emotional and economic abuse against women in qualifying domestic relationships. Depending on the facts, a magistrate may grant protection, residence, monetary or other orders. These are legal remedies that require the relevant process; no particular order is automatic. A Protection Officer, legal-aid authority or lawyer can help explain the options.",
                    "గృహ హింస నుంచి మహిళల రక్షణ చట్టం, వర్తించే గృహ సంబంధాల్లో మహిళలపై శారీరక, లైంగిక, మాటల, భావోద్వేగ, ఆర్థిక హింసను గుర్తిస్తుంది. పరిస్థితులను బట్టి మేజిస్ట్రేట్ రక్షణ, నివాసం, ఆర్థిక సహాయం లేదా ఇతర ఉత్తర్వులు ఇవ్వవచ్చు. ఇవి సంబంధిత న్యాయ విధానం ద్వారా పొందే పరిష్కారాలు; ఏ ఉత్తర్వూ స్వయంచాలకంగా రాదు. రక్షణ అధికారి, న్యాయ సహాయ సంస్థ లేదా న్యాయవాది అవకాశాలను వివరించగలరు."),
                section("Ask for practical assistance", "ఆచరణాత్మక సహాయం కోరండి",
                    "Keep available medical records, messages and a brief incident timeline safely. Ask about shelter, counselling, police assistance and legal aid; local availability varies. Women are an eligibility category for legal services under the Legal Services Authorities Act, subject to the authority's assessment of the case. Contact DLSA or NALSA's 15100 for guidance. Other people experiencing abuse can also seek police, medical and legal help for their circumstances.",
                    "అందుబాటులో ఉన్న వైద్య రికార్డులు, సందేశాలు, సంఘటనల సంక్షిప్త క్రమాన్ని సురక్షితంగా భద్రపరచండి. ఆశ్రయం, కౌన్సెలింగ్, పోలీసు సహాయం, న్యాయ సహాయం గురించి అడగండి; స్థానిక సేవలు మారవచ్చు. న్యాయ సేవాధికార సంస్థల చట్టంలో మహిళలు అర్హత వర్గంలో ఉంటారు; కేసును సంబంధిత సంస్థ పరిశీలిస్తుంది. మార్గదర్శకత్వం కోసం DLSA లేదా NALSA 15100ను సంప్రదించండి. హింసను ఎదుర్కొనే ఇతర వ్యక్తులు కూడా తమ పరిస్థితికి తగిన పోలీసు, వైద్య, న్యాయ సహాయం కోరవచ్చు."),
            ),
            sources = listOf(
                LegalSource("India Code — Protection of Women from Domestic Violence Act, 2005", "https://www.indiacode.nic.in/handle/123456789/2021?view_type=browse"),
                LegalSource("Ministry of Women and Child Development", "https://wcd.gov.in/"),
                LegalSource("National Legal Services Authority", "https://nalsa.gov.in/"),
            ),
        ),
        LegalArticle(
            id = "child-safety-and-protection",
            categoryId = "family",
            title = text("Child safety & reporting abuse", "బాలల భద్రత, దుర్వినియోగంపై ఫిర్యాదు"),
            summary = text("Support a child safely and find the right protection and reporting channels.", "పిల్లలకు సురక్షితంగా తోడ్పడి, తగిన రక్షణ, ఫిర్యాదు మార్గాలను తెలుసుకోండి."),
            readingMinutes = 3,
            sections = listOf(
                section("Listen and protect", "వినండి, రక్షించండి",
                    "If a child describes abuse, listen calmly, reassure them that seeking help is right, and do not blame them. Avoid repeated questioning or making them confront the suspected person. For immediate danger call 112. Child Helpline 1098 can help connect children in distress with protection services. Seek medical help when needed.",
                    "పిల్లలు దుర్వినియోగం గురించి చెబితే ప్రశాంతంగా వినండి. సహాయం కోరడం సరైనదని భరోసా ఇవ్వండి; వారిని తప్పుపట్టకండి. పదే పదే ప్రశ్నించడం లేదా అనుమానితుడిని ఎదుర్కొనేలా చేయడం మానండి. తక్షణ ప్రమాదంలో 112కు కాల్ చేయండి. బాలల హెల్ప్‌లైన్ 1098 ఇబ్బందుల్లో ఉన్న పిల్లలను రక్షణ సేవలకు అనుసంధానించడంలో సహాయపడగలదు. అవసరమైతే వైద్య సహాయం పొందండి."),
                section("Report through proper channels", "తగిన మార్గాల్లో ఫిర్యాదు చేయండి",
                    "The Protection of Children from Sexual Offences (POCSO) Act protects persons below 18 from specified sexual offences. If you know a POCSO offence has occurred, or apprehend that one is likely to occur, you must inform the local police or Special Juvenile Police Unit. A Child Welfare Committee or District Child Protection Unit can assist with protection needs. Ask authorities about child-friendly procedures and support.",
                    "లైంగిక నేరాల నుంచి బాలల రక్షణ (POCSO) చట్టం 18 ఏళ్లలోపు వారిని నిర్దిష్ట లైంగిక నేరాల నుంచి రక్షిస్తుంది. POCSO నేరం జరిగినట్లు తెలిసినా లేదా జరగవచ్చని ఆందోళన ఉన్నా, స్థానిక పోలీసులకు లేదా ప్రత్యేక బాలల పోలీసు విభాగానికి తప్పనిసరిగా సమాచారం ఇవ్వాలి. బాలల సంక్షేమ కమిటీ లేదా జిల్లా బాలల రక్షణ విభాగం రక్షణ అవసరాల్లో సహాయపడగలదు. పిల్లలకు అనుకూలమైన విధానాలు, సహాయం గురించి అధికారులను అడగండి."),
                section("Protect the child's identity", "పిల్లల గుర్తింపును రక్షించండి",
                    "Do not publicly share a child's name, photograph, school or details that could identify a child who is a victim of sexual abuse. Keep records secure and give relevant information to authorised officials. Do not download or circulate child sexual abuse material. For online abuse, report through the cybercrime portal and seek police guidance on evidence preservation.",
                    "లైంగిక దుర్వినియోగానికి గురైన పిల్లల పేరు, ఫొటో, పాఠశాల లేదా వారిని గుర్తించే వివరాలను బహిరంగంగా పంచుకోవద్దు. రికార్డులను సురక్షితంగా ఉంచి, సంబంధిత సమాచారాన్ని అధికారిక బాధ్యత గల వ్యక్తులకు ఇవ్వండి. బాలల లైంగిక దుర్వినియోగ కంటెంట్‌ను డౌన్‌లోడ్ చేయకండి, పంపిణీ చేయకండి. ఆన్‌లైన్ దుర్వినియోగంపై సైబర్ నేరాల పోర్టల్‌లో ఫిర్యాదు చేసి, ఆధారాల భద్రతపై పోలీసుల సూచనలు తీసుకోండి."),
            ),
            sources = listOf(
                LegalSource("India Code — Protection of Children from Sexual Offences Act, 2012", "https://www.indiacode.nic.in/indiacode/handle/123456789/2079?view_type=browse"),
                LegalSource("Ministry of Women and Child Development — child protection services", "https://wcd.gov.in/"),
                LegalSource("National Commission for Protection of Child Rights", "https://ncpcr.gov.in/"),
            ),
        ),
        LegalArticle(
            id = "workplace-pay-and-records",
            categoryId = "workplace",
            title = text("Workplace pay: keep records & seek help", "పని ప్రదేశంలో వేతనం: రికార్డులు, సహాయం"),
            summary = text("Document wages, working time and employment terms before raising a concern.", "సమస్యను తెలియజేసే ముందు వేతనం, పని సమయం, ఉద్యోగ నిబంధనలను నమోదు చేయండి."),
            readingMinutes = 3,
            sections = listOf(
                section("Build a clear record", "స్పష్టమైన రికార్డు ఉంచండి",
                    "Keep your offer or appointment letter, wage slips, attendance, work messages and payment records. Note the agreed wage, days worked, deductions and amounts actually received. For informal work, a dated personal record and available messages can still help explain the facts. Store copies outside a work account you could lose access to.",
                    "ఉద్యోగ ఆఫర్ లేదా నియామక పత్రం, వేతన స్లిప్పులు, హాజరు, పని సందేశాలు, చెల్లింపు రికార్డులను భద్రపరచండి. ఒప్పుకున్న వేతనం, పని చేసిన రోజులు, కోతలు, అందుకున్న మొత్తాలను నమోదు చేయండి. అసంఘటిత పనిలోనూ తేదీలతో కూడిన వ్యక్తిగత రికార్డు, అందుబాటులో ఉన్న సందేశాలు విషయాలను వివరించడానికి ఉపయోగపడవచ్చు. ప్రవేశం కోల్పోయే అవకాశం ఉన్న కార్యాలయ ఖాతా బయట కూడా ప్రతులను దాచండి."),
                section("Raise a specific concern", "నిర్దిష్ట సమస్యను తెలియజేయండి",
                    "For missing pay or an unexplained deduction, ask the employer or payroll team in writing for an explanation and correction. Keep a copy. Minimum wages, working-time rules, leave and remedies depend on the applicable law, worker category, location and establishment. Do not rely on a single nationwide amount or assume every worker has identical entitlements.",
                    "వేతనం అందకపోయినా లేదా కారణం తెలియని కోత ఉన్నా, వివరణ, సవరణ కోసం యజమాని లేదా వేతన విభాగానికి రాతపూర్వకంగా అడగండి. ప్రతిని దాచండి. కనీస వేతనం, పని సమయం, సెలవులు, పరిష్కారాలు వర్తించే చట్టం, కార్మిక వర్గం, ప్రదేశం, సంస్థపై ఆధారపడతాయి. దేశమంతటా ఒకే మొత్తం ఉంటుందని లేదా ప్రతి కార్మికుడికి ఒకే హక్కులు ఉంటాయని భావించకండి."),
                section("Find the appropriate authority", "తగిన అధికారిని సంప్రదించండి",
                    "Your state labour department or the relevant central labour authority can help identify the right complaint route. The Ministry of Labour and Employment provides links to official services. Procedures and deadlines vary, so seek guidance promptly and take your records. For a dismissal, settlement or disputed contract, obtain individual legal advice before signing a release or accepting terms you do not understand.",
                    "మీ రాష్ట్ర కార్మిక శాఖ లేదా సంబంధిత కేంద్ర కార్మిక అధికారి తగిన ఫిర్యాదు మార్గాన్ని గుర్తించడంలో సహాయపడగలరు. కార్మిక, ఉపాధి మంత్రిత్వ శాఖ అధికారిక సేవల లింకులను అందిస్తుంది. విధానాలు, గడువులు మారుతాయి కాబట్టి త్వరగా మార్గదర్శకత్వం పొంది, మీ రికార్డులను తీసుకెళ్లండి. ఉద్యోగం నుంచి తొలగింపు, రాజీ లేదా ఒప్పంద వివాదంలో అర్థం కాని షరతులను అంగీకరించే ముందు వ్యక్తిగత న్యాయ సలహా తీసుకోండి."),
            ),
            sources = listOf(
                LegalSource("Ministry of Labour and Employment — laws and official services", "https://labour.gov.in/"),
                LegalSource("Ministry of Labour and Employment — labour-code implementation", "https://labour.gov.in/sites/default/files/pib2192463.pdf"),
                LegalSource("India Code — applicable labour legislation", "https://www.indiacode.nic.in/"),
                LegalSource("National Legal Services Authority", "https://nalsa.gov.in/"),
            ),
        ),
        LegalArticle(
            id = "workplace-sexual-harassment",
            categoryId = "workplace",
            title = text("Sexual harassment at work: reporting options", "పని ప్రదేశంలో లైంగిక వేధింపులు: ఫిర్యాదు మార్గాలు"),
            summary = text("Understand the Internal Committee, Local Committee and safer ways to seek support.", "అంతర్గత కమిటీ, స్థానిక కమిటీ, సహాయం కోరే సురక్షిత మార్గాలను తెలుసుకోండి."),
            readingMinutes = 4,
            sections = listOf(
                section("Understand the protection", "రక్షణను అర్థం చేసుకోండి",
                    "The Sexual Harassment of Women at Workplace Act addresses unwelcome sexual conduct against women at work, including certain verbal, physical or non-verbal conduct. Covered workplaces and relationships are broader than a traditional office. Employers with ten or more workers are required to constitute an Internal Committee. A district Local Committee has a role for establishments with fewer than ten workers and complaints against the employer.",
                    "పని ప్రదేశంలో మహిళలపై లైంగిక వేధింపుల నిరోధక చట్టం అవాంఛిత లైంగిక ప్రవర్తనను, కొన్ని మాటల, శారీరక లేదా సంజ్ఞల ప్రవర్తనతో సహా, పరిష్కరిస్తుంది. వర్తించే పని ప్రదేశాలు సాధారణ కార్యాలయానికే పరిమితం కావు. పది లేదా అంతకంటే ఎక్కువ మంది కార్మికులు ఉన్న సంస్థలు అంతర్గత కమిటీని ఏర్పాటు చేయాలి. పది మందికంటే తక్కువ ఉన్న సంస్థల్లో, యజమానిపై ఫిర్యాదుల్లో జిల్లా స్థానిక కమిటీకి పాత్ర ఉంటుంది."),
                section("Record and seek assistance", "నమోదు చేసి సహాయం కోరండి",
                    "Keep a dated account, messages and witness details safely. Ask your workplace for the committee's contact information and complaint process. Under the Act, a complaint is ordinarily made within three months of the incident, or the last incident in a series; the committee may extend this by up to three months for recorded reasons. Ask for assistance with a written complaint if needed, and seek advice promptly about your dates.",
                    "తేదీలతో సంఘటనల వివరాలు, సందేశాలు, సాక్షుల సమాచారాన్ని సురక్షితంగా దాచండి. కమిటీ సంప్రదింపు వివరాలు, ఫిర్యాదు విధానాన్ని కార్యాలయంలో అడగండి. చట్టం ప్రకారం సాధారణంగా సంఘటన నుంచి లేదా వరుస సంఘటనల్లో చివరి సంఘటన నుంచి మూడు నెలల్లో ఫిర్యాదు చేయాలి. నమోదు చేసిన కారణాలతో కమిటీ మరో మూడు నెలల వరకు గడువును పొడిగించవచ్చు. అవసరమైతే రాతపూర్వక ఫిర్యాదు తయారీలో సహాయం అడిగి, మీ తేదీలపై త్వరగా సలహా తీసుకోండి."),
                section("Use additional support when needed", "అవసరమైతే అదనపు సహాయం పొందండి",
                    "SHe-Box is the government's online platform for workplace sexual-harassment complaints; check its current instructions and routing. Committee proceedings have confidentiality requirements. If conduct may also be a criminal offence, police reporting is a separate option; for immediate danger call 112. Other workers can ask about employer policies and applicable legal remedies. Do not assume the committee process covers every situation or guarantees an outcome.",
                    "పని ప్రదేశంలో లైంగిక వేధింపుల ఫిర్యాదులకు ప్రభుత్వ ఆన్‌లైన్ వేదిక SHe-Box; ప్రస్తుత సూచనలు, ఫిర్యాదు పంపే విధానాన్ని పరిశీలించండి. కమిటీ విచారణలకు గోప్యత నిబంధనలు ఉన్నాయి. ప్రవర్తన క్రిమినల్ నేరం కూడా అయితే పోలీసులకు ఫిర్యాదు చేయడం ప్రత్యేక మార్గం. తక్షణ ప్రమాదంలో 112కు కాల్ చేయండి. ఇతర కార్మికులు సంస్థ విధానాలు, వర్తించే న్యాయ పరిష్కారాల గురించి అడగవచ్చు. ప్రతి పరిస్థితి కమిటీ పరిధిలోకి వస్తుందని లేదా ఫలితానికి హామీ ఉందని భావించకండి."),
            ),
            sources = listOf(
                LegalSource("India Code — Sexual Harassment of Women at Workplace Act, 2013", "https://www.indiacode.nic.in/bitstream/123456789/15239/1/sexual_harassment_act_2013.pdf"),
                LegalSource("SHe-Box — Ministry of Women and Child Development", "https://shebox.wcd.gov.in/"),
                LegalSource("Ministry of Women and Child Development", "https://wcd.gov.in/"),
            ),
        ),
        LegalArticle(
            id = "right-to-information",
            categoryId = "services",
            title = text("RTI: request information from public authorities", "RTI: ప్రభుత్వ సంస్థల నుంచి సమాచారం కోరండి"),
            summary = text("Ask for existing records clearly and understand the information-request process.", "ఇప్పటికే ఉన్న రికార్డులను స్పష్టంగా కోరి, సమాచార అభ్యర్థన విధానాన్ని తెలుసుకోండి."),
            readingMinutes = 4,
            sections = listOf(
                section("Ask for identifiable records", "గుర్తించగల రికార్డులను అడగండి",
                    "The Right to Information Act gives Indian citizens a route to request information held by public authorities, subject to exemptions. Identify the authority, period and records you need, such as an order, expenditure record or application status record. Ask for existing information rather than asking an officer to create an opinion or solve a grievance. You do not need to give a reason for requesting information.",
                    "సమాచార హక్కు చట్టం ప్రకారం భారత పౌరులు మినహాయింపులకు లోబడి ప్రభుత్వ సంస్థల వద్ద ఉన్న సమాచారాన్ని కోరవచ్చు. సంస్థ, కాలవ్యవధి, అవసరమైన ఉత్తర్వు, వ్యయ రికార్డు లేదా దరఖాస్తు స్థితి రికార్డు వంటి వివరాలను స్పష్టంగా చెప్పండి. కొత్త అభిప్రాయం తయారు చేయమని లేదా ఫిర్యాదును పరిష్కరించమని అడగకుండా, ఇప్పటికే ఉన్న సమాచారాన్ని కోరండి. సమాచారం ఎందుకు కావాలో కారణం చెప్పాల్సిన అవసరం లేదు."),
                section("Use the correct filing route", "సరైన దాఖలు మార్గాన్ని ఉపయోగించండి",
                    "Submit to the relevant Public Information Officer using the authority's published process. RTI Online serves participating Central Government public authorities; it is not a universal portal for state government requests. States may have separate portals and rules. Check applicable fees, payment methods and assistance options. Keep the application and acknowledgement. Below-poverty-line applicants have fee exemptions under the Act, subject to the required proof.",
                    "సంస్థ ప్రకటించిన విధానంలో సంబంధిత ప్రజా సమాచార అధికారికి దరఖాస్తు చేయండి. RTI Online పాల్గొనే కేంద్ర ప్రభుత్వ సంస్థలకు సేవలందిస్తుంది; అన్ని రాష్ట్ర ప్రభుత్వ అభ్యర్థనలకు ఇది సాధారణ పోర్టల్ కాదు. రాష్ట్రాలకు ప్రత్యేక పోర్టళ్లు, నియమాలు ఉండవచ్చు. రుసుములు, చెల్లింపు మార్గాలు, సహాయం గురించి తెలుసుకోండి. దరఖాస్తు, స్వీకరణ రుజువును దాచండి. అవసరమైన రుజువుకు లోబడి, దారిద్ర్య రేఖకు దిగువన ఉన్న దరఖాస్తుదారులకు చట్టం ప్రకారం రుసుము మినహాయింపు ఉంటుంది."),
                section("Track deadlines and appeals", "గడువులు, అప్పీళ్లు గమనించండి",
                    "The ordinary response period is 30 days; information concerning a person's life or liberty has a 48-hour rule. Transfers, third-party processes and other circumstances can affect timelines. If information is refused or a reply is not received, appeal routes exist with their own deadlines. Read the response carefully and consult the Act or seek advice for your case. RTI does not override every privacy, security or other statutory exemption.",
                    "సాధారణ సమాధాన గడువు 30 రోజులు; వ్యక్తి జీవితం లేదా స్వేచ్ఛకు సంబంధించిన సమాచారానికి 48 గంటల నియమం ఉంది. బదిలీలు, మూడో వ్యక్తి ప్రక్రియలు, ఇతర పరిస్థితులు గడువులను ప్రభావితం చేయవచ్చు. సమాచారం నిరాకరించినా లేదా సమాధానం రాకపోయినా, ప్రత్యేక గడువులతో అప్పీల్ మార్గాలు ఉన్నాయి. సమాధానాన్ని జాగ్రత్తగా చదివి, చట్టాన్ని పరిశీలించండి లేదా మీ కేసుకు సలహా తీసుకోండి. RTI అన్ని గోప్యత, భద్రత లేదా ఇతర చట్టపరమైన మినహాయింపులను అధిగమించదు."),
            ),
            sources = listOf(
                LegalSource("RTI Online — Central Government portal", "https://rtionline.gov.in/"),
                LegalSource("Department of Personnel and Training — RTI resources", "https://rti.gov.in/"),
                LegalSource("India Code — Right to Information Act, 2005", "https://www.indiacode.nic.in/bitstream/123456789/2065/1/aA2005-22.pdf"),
            ),
        ),
        LegalArticle(
            id = "public-service-grievances",
            categoryId = "services",
            title = text("Raise a grievance about a public service", "ప్రభుత్వ సేవపై ఫిర్యాదు చేయండి"),
            summary = text("Organise your documents and choose a suitable departmental grievance route.", "పత్రాలను సిద్ధం చేసి, సంబంధిత శాఖ ఫిర్యాదు మార్గాన్ని ఎంచుకోండి."),
            readingMinutes = 3,
            sections = listOf(
                section("Describe the problem and the request", "సమస్య, అభ్యర్థనను వివరించండి",
                    "For a delayed certificate, unanswered application or service issue, keep the application number, dates, receipt and earlier communication. Explain what happened and what action you are requesting. Use factual, respectful language and attach relevant copies. Do not include unnecessary identity or financial details, and keep original documents unless an official process requires them.",
                    "ఆలస్యమైన ధృవపత్రం, సమాధానం రాని దరఖాస్తు లేదా సేవా సమస్య కోసం దరఖాస్తు నంబర్, తేదీలు, రసీదు, గత సమాచారాన్ని భద్రపరచండి. ఏం జరిగింది, ఏ చర్య కోరుతున్నారో వివరించండి. వాస్తవాలను మర్యాదగా రాసి, సంబంధిత ప్రతులను జత చేయండి. అవసరం లేని గుర్తింపు లేదా ఆర్థిక వివరాలను చేర్చకండి. అధికారిక విధానంలో అవసరమైతే తప్ప అసలు పత్రాలను మీ వద్ద ఉంచుకోండి."),
                section("Choose the relevant portal", "సంబంధిత పోర్టల్‌ను ఎంచుకోండి",
                    "Start with the department's grievance officer or official service portal. CPGRAMS is a public-grievance platform connected with government ministries, departments and states; routing and coverage vary. It excludes certain matters, including RTI matters and court-related or sub judice matters. Use an RTI request for information and the relevant appeal process for a statutory decision. Check the portal's current instructions before submitting.",
                    "శాఖ ఫిర్యాదు అధికారి లేదా అధికారిక సేవా పోర్టల్‌తో ప్రారంభించండి. CPGRAMS ప్రభుత్వ మంత్రిత్వ శాఖలు, విభాగాలు, రాష్ట్రాలతో అనుసంధానమైన ప్రజా ఫిర్యాదు వేదిక; పరిధి, పంపే విధానం మారవచ్చు. RTI విషయాలు, కోర్టుకు సంబంధించిన లేదా కోర్టులో విచారణలో ఉన్న విషయాలు వంటి కొన్ని అంశాలను ఇది స్వీకరించదు. సమాచారం కోసం RTI అభ్యర్థనను, చట్టపరమైన నిర్ణయానికి సంబంధిత అప్పీల్ విధానాన్ని ఉపయోగించండి. సమర్పించే ముందు పోర్టల్ ప్రస్తుత సూచనలను పరిశీలించండి."),
                section("Track and follow up", "స్థితిని గమనించి, తదుపరి చర్య తీసుకోండి",
                    "Save your grievance registration number and check its status through the official site. Read the response and use any available feedback or appeal option when appropriate. A grievance does not automatically suspend a legal deadline or replace a court or statutory appeal. If your rights or a deadline are at stake, consult the department's rules or seek legal advice promptly.",
                    "ఫిర్యాదు నమోదు నంబర్‌ను దాచి, అధికారిక వెబ్‌సైట్‌లో స్థితిని చూడండి. సమాధానాన్ని చదివి, అవసరమైతే అందుబాటులో ఉన్న అభిప్రాయం లేదా అప్పీల్ అవకాశాన్ని ఉపయోగించండి. ఫిర్యాదు చేయడం వల్ల చట్టపరమైన గడువు స్వయంచాలకంగా ఆగదు; అది కోర్టు లేదా చట్టపరమైన అప్పీల్‌కు ప్రత్యామ్నాయం కాదు. మీ హక్కులు లేదా గడువు ప్రభావితమైతే శాఖ నియమాలను పరిశీలించండి లేదా త్వరగా న్యాయ సలహా తీసుకోండి."),
            ),
            sources = listOf(
                LegalSource("CPGRAMS — grievance process and exclusions", "https://pgportal.gov.in/Home/Faq"),
                LegalSource("Department of Administrative Reforms and Public Grievances", "https://darpg.gov.in/"),
                LegalSource("RTI Online", "https://rtionline.gov.in/"),
            ),
        ),
    )

    /** Search both languages, including article bodies, without depending on the selected UI language. */
    fun search(query: String, categoryId: String? = null): List<LegalArticle> {
        val terms = query.trim().lowercase(Locale.ROOT).split(Regex("\\s+"))
            .filter(String::isNotBlank)
        return articles.filter { article ->
            if (categoryId != null && article.categoryId != categoryId) return@filter false
            if (terms.isEmpty()) return@filter true
            val category = categories.firstOrNull { it.id == article.categoryId }
            val searchable = buildString {
                append(article.title.searchText())
                append(' ')
                append(article.summary.searchText())
                article.sections.forEach { section ->
                    append(' ')
                    append(section.heading.searchText())
                    append(' ')
                    append(section.body.searchText())
                }
                category?.let {
                    append(' ')
                    append(it.name.searchText())
                    append(' ')
                    append(it.description.searchText())
                }
            }.lowercase(Locale.ROOT)
            terms.all(searchable::contains)
        }
    }

    fun articleById(id: String): LegalArticle? = articles.firstOrNull { it.id == id }

    private fun LocalizedText.searchText() = "$english $telugu"
    private fun text(english: String, telugu: String) = LocalizedText(english, telugu)
    private fun section(heading: String, headingTelugu: String, body: String, bodyTelugu: String) =
        ArticleSection(text(heading, headingTelugu), text(body, bodyTelugu))
}
