import {Alert, Button, StyleSheet, Text, View, ScrollView, Image} from 'react-native'
import Carousel, {Pagination} from 'react-native-snap-carousel'
import Constants from 'expo-constants'
import {useState} from 'react'

const data = [
  {
    title: "Foundawtion: творческий проект Сенегала",
    body: "Foundawtion – это инициатива, в рамках которой группа талантливых архитекторов превратила юг Сенегала в творческий эпицентр.",
    imgUrl: "http://brightmagazine.ru/wp-content/uploads/2022/03/pexels-hello-massamba-10509940-768x512.jpg"
  },
  {
    title: "Гитхорн: уголок в Нидерландах, где совсем нет автомобилей",
    body: "Десятки каналов и 176 мостов – богатство спокойной голландской деревушки Гитхорн. Там почтальон привозит письма на лодке, а автомобилей нет и в помине. Идеальное место, чтобы отдохнуть от городского шума и суеты.",
    imgUrl: "http://brightmagazine.ru/wp-content/uploads/2022/03/pexels-tanathip-rattanatum-2026451-768x512.jpg"
  },
  {
    title: "Самые лучшие страны мира для путешествий в одиночку",
    body: "Иногда в путешествие хочется отправиться в одиночку, чтобы побыть наедине с самим собой и найти ответы на жизненные вопросы. Сегодня мы расскажем вам о самых безопасных странах мира именно для таких путешествий.",
    imgUrl: "http://brightmagazine.ru/wp-content/uploads/2022/02/pexels-valentin-antonucci-691637-768x512.jpg"
  }
]

export default function App() {
  const [activeSlide, setActiveSlide] = useState(0);
  const RenderItem = ({ item, index }) => {
    return (
        <ScrollView style={styles.card}>
          <Text style={styles.header}>{item.title}</Text>
          <Image
              source={{ uri: item.imgUrl }}
              style={styles.logoStyle}
          />
          <Text style={styles.body}>{item.body}</Text>
        </ScrollView>
    );
  }

  return (
      <View style={styles.app}>
        <Carousel
            layout={"default"}
            data={data}
            renderItem={RenderItem}
            sliderWidth={300}
            itemWidth={290}
            onSnapToItem={(index) => setActiveSlide(index)}
            swipeThreshold={100}
            inactiveSlideOpacity={0.4}
            containerCustomStyle={{
              overflow: "visible",
              marginVertical: 5,
            }}
        />
        <Pagination
            dotsLength={data.length}
            activeDotIndex={activeSlide}
            dotStyle={{
              width: 10,
              height: 10,
              borderRadius: 10,
            }}>
        </Pagination>
        <Button
            title="Press me"
            onPress={() => Alert.alert('Thank you for pressing me!')}
            color={'purple'}
        />
      </View>
  );
}

const styles = StyleSheet.create({
  app: {
    flex: 1,
    paddingTop: Constants.statusBarHeight,
  },
  card: {
    marginLeft: 20
  },
  logoStyle: {
    width: 200,
    height: 300,
    marginLeft: 20,
    borderRadius: 15
  },
  header: {
    color: 'black',
    fontSize: 28,
    fontWeight: "bold",
    marginBottom: 20,
    marginLeft: 20,
    marginTop: 10,
  },
  body: {
    color: 'black',
    fontSize: 18,
    marginLeft: 20,
    marginTop: 25,
    marginRight: 40
  },
});
