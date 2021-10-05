<template>
  <div class="home">
    <img alt="Vue logo" src="../assets/logo.png">
    <v-form v-model="valid">
      <v-container>
        <v-row>
          <v-col
              cols="12"
              md="4"
          >
            <v-text-field
                v-model="username"
                label="Username"
                required
            ></v-text-field>
          </v-col>

          <v-col
              cols="12"
              md="4"
          >
            <v-text-field
                v-model="password"
                :append-icon="show ? 'mdi-eye' : 'mdi-eye-off'"
                :type="show ? 'text' : 'password'"
                @click:append="show = !show"
                label="Password"
                required
            ></v-text-field>
          </v-col>

          <v-col
              cols="12"
              md="4"
          >
            <v-btn
                class="mr-4"
                @click="submit">
              Submit
            </v-btn>
          </v-col>
        </v-row>
      </v-container>
    </v-form>
  </div>
</template>

<script>
export default {
  name: 'Home',
  data: () => ({
    show: false,
    username: '',
    password: '',
    jwt: '',
  }),
  methods: {
    async submit() {
      const requestOptions = {
        method: "POST",
        headers: {"Content-Type": "application/json"},
        body: JSON.stringify({uname: this.username, pass: this.password})
      };
      const response = await fetch("http://localhost:8080/login", requestOptions);
      const data =  await response.json();
      this.jwt = data.jwt;
    }
  }
}
</script>
